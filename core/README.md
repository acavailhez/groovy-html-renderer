# groovy-html-renderer-core

Core feature of groovy-html-renderer

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

## Full page

To render a full html page, extend `HtmlPage`:

```
 class BasicPage extends HtmlPage{
 
  @Override
  protected String title() {
      return 'Page about politics'
  }
  
  protected void body() {
      div {
          escape << "text"
      }
  }
 }
 ```
 
 renders:
 
 ```
 <!doctype html>
 <html>
  <head>
   <meta charset="utf-8">
   <title>Page about politics</title>
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta http-equiv="x-ua-compatible" content="ie=edge">
  </head>
  <body>
   <div>text</div>
  </body>
 </html>
 ```
 
 See `HtmlPage.groovy` for more details on what you can configure

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

This can be useful when building traits that add new behavior

## HtmlFragment

Html fragments are snippet of html with some added features:

### Javascript

It's convenient to write small javascript snippets where they are relevant, only to have them be deferred to the end of the document,

```
div{
   div{
     escape << 'text to print'
     js << 'execute();'
   }
}
```

The javascript will be collected separately. 
In a `HtmlPage`, this javascript will be appended to a `<script>` before the `<body>` is closed
In a standard `HtmlFragment`, the javascript will be accessible using `getRawJavascript()`

### Deferred html

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

In a `HtmlPage`, this html will be written before the `<body>` is closed
In a standard `HtmlFragment`, the deferred html will be accessible using `getRawDeferredHtml()`
