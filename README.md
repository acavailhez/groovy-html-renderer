# html-renderer

html-renderer is a in-code html rendering engine using the groovy syntax to help generate correct html documents

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

## Javascript

It's convenient to write small javascript snipets where they are relevant, only to have them be deferred to the end of the document,

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

