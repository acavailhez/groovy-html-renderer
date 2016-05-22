# groovy-html-renderer

in-code html5 rendering engine leveraging the groovy syntax:

```
div(class:'box'){
  div(class:'box-body'){
    escape << "content of the box"
  }
}
```

renders:

```
<div class="box">
  <div class="box-body">
     content of the box
  </div>
</div>
```

## Why?

Server-side rendering of complex html is not everyone's cup of tea, but if you fancy it, `groovy-html-renderer` provides a reliable way to do it

In java, your choice is usually limited to jsp or similar templating engine, working on html and adding clumsy `if` and `for` statements in custom tags (`<c:if>`).
In `groovy-html-renderer` you are rendering the html in the code itself, so you can leverage the power of the tools you already have, as well as type-check your objects.

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

renders:

```
<div>
  <span>oups</span>
</div>
```

This will prevent the whole document from crashing if only a non-critical part failed to render

Using Groovy's `Trait`, it's easy to add new shortcuts and features to the syntax. 
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

With `Bootstrap4Trait` it can be simplified to:

```
public class Snippet extends Html implements Bootstrap4Trait{
  public void build() {
  
    modal(title: "Modal title", closeLabel: "Close") {
      p("One fine body…")
    } {
      button(btn('data-dismiss': 'modal'), "Close")
      button(btn(color: Bootstrap4Color.PRIMARY), "Save changes")
    }  
         
  }
}
```

Exposing only the important content and making the code easier to read


## Performances

The order of magnitude you should expect for the rendering of a html page is < 10ms.


This is a number to consider relative to what you are doing around the generation of the page. If you are making even a single SQL query in order to generate the page, then using `groovy-html-renderer` will not have any noticeable impact on your performances.
Now if you are rendering static content, then `groovy-html-renderer` is probably not the right tool for the job.

Here are some tips to improve performances of your html pages:

- Use `@CompileStatic` in your pages. This will have a 5x performance boost on pages with a lot of subclosures
- Opt for a basic rendering engine for pages with a lot of static content. `groovy-html-renderer` will perform poorly there 

Let's have a look at the best and worst case scenarios, we compare against 1000 run `groovy-html-renderer` to Apache's `velocity` which is build for speed:

*Rendering the boostrap modal example - over 1000 runs*

| Velocity | groovy-html-renderer |
|---|---|
| 0.074ms | 0.495 ms | 

In this run, a small snippet with a for-loop, `groovy-html-renderer` performs 7x slower than the highly optimized `velocity` 
 
*Rendering the grails homepage - 1000 runs* 
| Velocity | groovy-html-renderer |
|---|---|
| 0.037ms | 1.262 ms | 

In the worst case scenario, a long static page with no customized content, `groovy-html-renderer` performs 34x slower than `velocity`

But even in the worst-case scenario, the rendering of a long static page containing a lot of tags written with closures, `groovy-html-renderer` renders the page in a matter of milliseconds.
Any SQL request made by your application will dwarf those times to negligeable amounts.

## Detailed documentation by component

### [Core features](core/README.md)    
### [Resources (js and css)](resources/README.md)
