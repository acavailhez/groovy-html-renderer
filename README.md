# groovy-html-renderer

in-code html rendering engine using the groovy syntax

```
div(class:'box'){
  div(class:'box-body'){
    escape << "content of the box"
  }
}
```

## Why?

Server-side rendering of complex html is not everyone's cup of tea, but if you fancy it, `groovy-html-renderer` provides a solid way to do it

Rendering engines that add new tags to html itself can become quite messy (looking at you jsp)

So instead of bringing code to html by add clumsy `if` and `for` statements in custom tags (`<c:if>`), groovy-html-renderer brings html to the code itself.
And the syntax of groovy is a suprisingly good fit for this:

```
div(class:'box'){
  div(class:'box-body'){
    escape << "content of the box"
  }
}
```

can render:

```
<div class="box">
  <div class="box">
     content of the box
  </div>
</div>
```

Once you are in code, all sorts of interesting features become possible, such as the `attempt` function, which will act like a try-catch:

```
div {
    attempt {
        div {
            escape << 'text'
            throw new Exception("oups")
        }
    } { Throwable t ->
        span {
            escape << 'failed with:' << t.getMessage()
        }
    }
}
```

This will prevent the whole document from crashing if only a non-critical part of it failed to render

Using Groovy's traits, it's easy to add new shortcuts and features to the syntax. 
Taking the example of Bootstrap's modal ([http://getbootstrap.com/javascript/#static-example](http://getbootstrap.com/javascript/#static-example)), writing it directly requires typing:

```
<div class="modal fade" tabindex="-1" role="dialog">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
           <h4 class="modal-title">Modal title</h4>
         </div>
         <div class="modal-body">
           <p>One fine body&hellip;</p>
         </div>
         <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
           <button type="button" class="btn btn-primary">Save changes</button>
         </div>
       </div><!-- /.modal-content -->
     </div><!-- /.modal-dialog -->
   </div><!-- /.modal -->
```

It is possible to write a `BootstrapHtmlTrait` which would simplify it to:

```
bootstrapSimpleModal("Modal title",tabindex:'-1'){
  p("One fine body…")
}{
  bootstrapButton("Close", btnClass:'default', 'data-dismiss':'modal')
  bootstrapButton("Save changes", btnClass:'primary')
}
```

Exposing only the important content and making the code easier to read

Let's jump into the features


## Basic rendering

To render a simple HTML piece, extend `Html`:

```
class BasicHtml extends Html{
 @Override
 public void build() {
  div(class: 'foo bar') {
   escape << 'html5 forever <3'
  }
 }
}

String html = new BasicHtml().render()
```

This will render the compact html:
`<div class="foo bar">html5 forever &lt;3</div>`

To render it in a visually appealing way, do:
`String html = new BasicHtml().withStyle(HtmlStyle.PRETTY).render()`

This will render:

```
<div class="foo bar">
  html5 forever &lt;3
</div>
```

## Tags

Html tags are rendered using a groovy closure, so:

```
div(attribute:"value",'attribute-two':"value 2"){
   html << '<span class="icon"></span>'
   div{
     escape << 'text to print'
   }
}
```

Will render:

```
<div attribute="value" attribute-two="value">
 <span class="icon"></span>
 <div>
  text to print
 </div>
</div>
```

## Attempt

If the generation of your html throws an exception, then all html is lost
For complex pages, you may want to attempt rendering some elements and continue if that element failed, even providing a fallback:

```
div {
    attempt {
        div {
            escape << 'text'
            throw new Exception("oups")
        }
    } { Throwable t ->
        span {
            escape << 'failed with:' << t.getMessage()
        }
    }
}
```

Will render:

```
<div>
 <span>failed with:oups</span>
</div>
```

## Scope

You can store some variables at the current DOM element level to retrieve later

```
div {
    scope.put("key",1)
    div {
        int value = scope.get("key")
        escape << 'text'
    }
}
```

## Javascript

It's convenient to write small javascript snippets where they are relevant, only to have them be deferred to the end of the document,

```
div{
   div{
     escape << 'text to print'
     js << 'execute();'
   }
}
```

## Defer html

Some content like modals is better deferred at the end of the document, to isolate it from the current css nesting,
but this content is better rendered in place when you need it, so it's possible to invoke some html to be deferred to the end of the document:

```
div {
    escape << "text"
    defer {
        div(class: 'modal') {
            escape << 'deferred'
        }
    }
}
```

