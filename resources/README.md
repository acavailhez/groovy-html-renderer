# groovy-html-renderer-resources

Handling css and javascript for pages

## Overview

You define a pack of resources and then inject it into your page:

```
HtmlResourcesPack pack = new HtmlResourcesPack()
pack.add('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css')
pack.add('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js')
    .withDisposition(HtmlResourceDisposition.FOOT)

public class SimplePage extends HtmlPage {

    protected String title() {
        return "Lee Sedol beaten by Alpha go"
    }

    protected void head() {
        resource(bootstrap)
    }

    protected void body() {
        div {
            escape << "text"
        }
    }
}
```

will render

```
<!doctype html>
<html>
 <head>
  ...
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" rel="stylesheet" type="text/css">
 </head>
 <body>
  <div>text</div>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js"> </script>
 </body>
</html>
```

## Disposition

When adding a resource you can specify where it should be rendered

```
pack.add('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js')
    .withDisposition(HtmlResourceDisposition.FOOT)
```

will render it before the `</body>` tag. 

By default the disposition is `HEAD`

### TODO

- bundles
- minify