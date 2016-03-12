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



