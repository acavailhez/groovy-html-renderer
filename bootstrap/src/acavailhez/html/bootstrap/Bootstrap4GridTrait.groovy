package acavailhez.html.bootstrap

import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes
import org.apache.log4j.Logger

// http://v4-alpha.getbootstrap.com/layout/grid/
// Will manage the rows automatically
trait Bootstrap4GridTrait extends Html5Trait {

    private static final Logger log = Logger.getLogger(Bootstrap4GridTrait)
    private static final String COLS_COUNT_KEY = '_bnoccr' // Bootstrap Number Of Columns In Current Row

    public void container(Closure body) {
        container([:], body)
    }

    public void container(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        div(attrs.addToClass('container')) {
            body()
            if (scope.opt(COLS_COUNT_KEY, Integer, 0) > 0) {
                log.warn('row forced closed with only ' + scope.get(COLS_COUNT_KEY, Integer) + ' cols')
                html << '</div>'
                scope.put(COLS_COUNT_KEY, 0)
            }
        }
    }

    private void bootstrapCol(Map map, int cols, Bootstrap4Size size, Closure body) {

        //open the row if first one
        if (scope.opt(COLS_COUNT_KEY, Integer, 0) == 0) {
            scope.put(COLS_COUNT_KEY, 0)
            html << '<div class="row">'
        }

        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        attrs.addToClass('col-' + size.name().toLowerCase() + '-' + cols)

        div(attrs) {
            if (body) {
                body()
            } else {
                html << '&nbsp;' // empty col for spacing
            }
        }

        scope.put(COLS_COUNT_KEY, scope.get(COLS_COUNT_KEY, Integer) + cols)

        //close the row if too big
        if (scope.get(COLS_COUNT_KEY, Integer) >= 12) {
            if (scope.get(COLS_COUNT_KEY, Integer) > 12) {
                log.warn('current bootstrap row is more than 12 cols')
            }
            html << '</div>'
            scope.put(COLS_COUNT_KEY, 0)
        }
    }

    public void colSm1(Closure body) {
        bootstrapCol([:], 1, Bootstrap4Size.SM, body)
    }

    public void colSm1(Map map, Closure body) {
        bootstrapCol(map, 1, Bootstrap4Size.SM, body)
    }

    public void colSm2(Closure body) {
        bootstrapCol([:], 2, Bootstrap4Size.SM, body)
    }

    public void colSm2(Map map, Closure body) {
        bootstrapCol(map, 2, Bootstrap4Size.SM, body)
    }

    public void colSm3(Closure body) {
        bootstrapCol([:], 3, Bootstrap4Size.SM, body)
    }

    public void colSm3(Map map, Closure body) {
        bootstrapCol(map, 3, Bootstrap4Size.SM, body)
    }

    public void colSm4(Closure body) {
        bootstrapCol([:], 4, Bootstrap4Size.SM, body)
    }

    public void colSm4(Map map, Closure body) {
        bootstrapCol(map, 4, Bootstrap4Size.SM, body)
    }

    public void colSm5(Closure body) {
        bootstrapCol([:], 5, Bootstrap4Size.SM, body)
    }

    public void colSm5(Map map, Closure body) {
        bootstrapCol(map, 5, Bootstrap4Size.SM, body)
    }

    public void colSm6(Closure body) {
        bootstrapCol([:], 6, Bootstrap4Size.SM, body)
    }

    public void colSm6(Map map, Closure body) {
        bootstrapCol(map, 6, Bootstrap4Size.SM, body)
    }

    public void colSm7(Closure body) {
        bootstrapCol([:], 7, Bootstrap4Size.SM, body)
    }

    public void colSm7(Map map, Closure body) {
        bootstrapCol(map, 7, Bootstrap4Size.SM, body)
    }

    public void colSm8(Closure body) {
        bootstrapCol([:], 8, Bootstrap4Size.SM, body)
    }

    public void colSm8(Map map, Closure body) {
        bootstrapCol(map, 8, Bootstrap4Size.SM, body)
    }

    public void colSm9(Closure body) {
        bootstrapCol([:], 9, Bootstrap4Size.SM, body)
    }

    public void colSm9(Map map, Closure body) {
        bootstrapCol(map, 9, Bootstrap4Size.SM, body)
    }

    public void colSm10(Closure body) {
        bootstrapCol([:], 10, Bootstrap4Size.SM, body)
    }

    public void colSm10(Map map, Closure body) {
        bootstrapCol(map, 10, Bootstrap4Size.SM, body)
    }

    public void colSm11(Closure body) {
        bootstrapCol([:], 11, Bootstrap4Size.SM, body)
    }

    public void colSm11(Map map, Closure body) {
        bootstrapCol(map, 11, Bootstrap4Size.SM, body)
    }

    public void colSm12(Closure body) {
        bootstrapCol([:], 12, Bootstrap4Size.SM, body)
    }

    public void colSm12(Map map, Closure body) {
        bootstrapCol(map, 12, Bootstrap4Size.SM, body)
    }

    public void colMd1(Closure body) {
        bootstrapCol([:], 1, Bootstrap4Size.MD, body)
    }

    public void colMd1(Map map, Closure body) {
        bootstrapCol(map, 1, Bootstrap4Size.MD, body)
    }

    public void colMd2(Closure body) {
        bootstrapCol([:], 2, Bootstrap4Size.MD, body)
    }

    public void colMd2(Map map, Closure body) {
        bootstrapCol(map, 2, Bootstrap4Size.MD, body)
    }

    public void colMd3(Closure body) {
        bootstrapCol([:], 3, Bootstrap4Size.MD, body)
    }

    public void colMd3(Map map, Closure body) {
        bootstrapCol(map, 3, Bootstrap4Size.MD, body)
    }

    public void colMd4(Closure body) {
        bootstrapCol([:], 4, Bootstrap4Size.MD, body)
    }

    public void colMd4(Map map, Closure body) {
        bootstrapCol(map, 4, Bootstrap4Size.MD, body)
    }

    public void colMd5(Closure body) {
        bootstrapCol([:], 5, Bootstrap4Size.MD, body)
    }

    public void colMd5(Map map, Closure body) {
        bootstrapCol(map, 5, Bootstrap4Size.MD, body)
    }

    public void colMd6(Closure body) {
        bootstrapCol([:], 6, Bootstrap4Size.MD, body)
    }

    public void colMd6(Map map, Closure body) {
        bootstrapCol(map, 6, Bootstrap4Size.MD, body)
    }

    public void colMd7(Closure body) {
        bootstrapCol([:], 7, Bootstrap4Size.MD, body)
    }

    public void colMd7(Map map, Closure body) {
        bootstrapCol(map, 7, Bootstrap4Size.MD, body)
    }

    public void colMd8(Closure body) {
        bootstrapCol([:], 8, Bootstrap4Size.MD, body)
    }

    public void colMd8(Map map, Closure body) {
        bootstrapCol(map, 8, Bootstrap4Size.MD, body)
    }

    public void colMd9(Closure body) {
        bootstrapCol([:], 9, Bootstrap4Size.MD, body)
    }

    public void colMd9(Map map, Closure body) {
        bootstrapCol(map, 9, Bootstrap4Size.MD, body)
    }

    public void colMd10(Closure body) {
        bootstrapCol([:], 10, Bootstrap4Size.MD, body)
    }

    public void colMd10(Map map, Closure body) {
        bootstrapCol(map, 10, Bootstrap4Size.MD, body)
    }

    public void colMd11(Closure body) {
        bootstrapCol([:], 11, Bootstrap4Size.MD, body)
    }

    public void colMd11(Map map, Closure body) {
        bootstrapCol(map, 11, Bootstrap4Size.MD, body)
    }

    public void colMd12(Closure body) {
        bootstrapCol([:], 12, Bootstrap4Size.MD, body)
    }

    public void colMd12(Map map, Closure body) {
        bootstrapCol(map, 12, Bootstrap4Size.MD, body)
    }

    public void colLg1(Closure body) {
        bootstrapCol([:], 1, Bootstrap4Size.LG, body)
    }

    public void colLg1(Map map, Closure body) {
        bootstrapCol(map, 1, Bootstrap4Size.LG, body)
    }

    public void colLg2(Closure body) {
        bootstrapCol([:], 2, Bootstrap4Size.LG, body)
    }

    public void colLg2(Map map, Closure body) {
        bootstrapCol(map, 2, Bootstrap4Size.LG, body)
    }

    public void colLg3(Closure body) {
        bootstrapCol([:], 3, Bootstrap4Size.LG, body)
    }

    public void colLg3(Map map, Closure body) {
        bootstrapCol(map, 3, Bootstrap4Size.LG, body)
    }

    public void colLg4(Closure body) {
        bootstrapCol([:], 4, Bootstrap4Size.LG, body)
    }

    public void colLg4(Map map, Closure body) {
        bootstrapCol(map, 4, Bootstrap4Size.LG, body)
    }

    public void colLg5(Closure body) {
        bootstrapCol([:], 5, Bootstrap4Size.LG, body)
    }

    public void colLg5(Map map, Closure body) {
        bootstrapCol(map, 5, Bootstrap4Size.LG, body)
    }

    public void colLg6(Closure body) {
        bootstrapCol([:], 6, Bootstrap4Size.LG, body)
    }

    public void colLg6(Map map, Closure body) {
        bootstrapCol(map, 6, Bootstrap4Size.LG, body)
    }

    public void colLg7(Closure body) {
        bootstrapCol([:], 7, Bootstrap4Size.LG, body)
    }

    public void colLg7(Map map, Closure body) {
        bootstrapCol(map, 7, Bootstrap4Size.LG, body)
    }

    public void colLg8(Closure body) {
        bootstrapCol([:], 8, Bootstrap4Size.LG, body)
    }

    public void colLg8(Map map, Closure body) {
        bootstrapCol(map, 8, Bootstrap4Size.LG, body)
    }

    public void colLg9(Closure body) {
        bootstrapCol([:], 9, Bootstrap4Size.LG, body)
    }

    public void colLg9(Map map, Closure body) {
        bootstrapCol(map, 9, Bootstrap4Size.LG, body)
    }

    public void colLg10(Closure body) {
        bootstrapCol([:], 10, Bootstrap4Size.LG, body)
    }

    public void colLg10(Map map, Closure body) {
        bootstrapCol(map, 10, Bootstrap4Size.LG, body)
    }

    public void colLg11(Closure body) {
        bootstrapCol([:], 11, Bootstrap4Size.LG, body)
    }

    public void colLg11(Map map, Closure body) {
        bootstrapCol(map, 11, Bootstrap4Size.LG, body)
    }

    public void colLg12(Closure body) {
        bootstrapCol([:], 12, Bootstrap4Size.LG, body)
    }

    public void colLg12(Map map, Closure body) {
        bootstrapCol(map, 12, Bootstrap4Size.LG, body)
    }

    public void colXl1(Closure body) {
        bootstrapCol([:], 1, Bootstrap4Size.XL, body)
    }

    public void colXl1(Map map, Closure body) {
        bootstrapCol(map, 1, Bootstrap4Size.XL, body)
    }

    public void colXl2(Closure body) {
        bootstrapCol([:], 2, Bootstrap4Size.XL, body)
    }

    public void colXl2(Map map, Closure body) {
        bootstrapCol(map, 2, Bootstrap4Size.XL, body)
    }

    public void colXl3(Closure body) {
        bootstrapCol([:], 3, Bootstrap4Size.XL, body)
    }

    public void colXl3(Map map, Closure body) {
        bootstrapCol(map, 3, Bootstrap4Size.XL, body)
    }

    public void colXl4(Closure body) {
        bootstrapCol([:], 4, Bootstrap4Size.XL, body)
    }

    public void colXl4(Map map, Closure body) {
        bootstrapCol(map, 4, Bootstrap4Size.XL, body)
    }

    public void colXl5(Closure body) {
        bootstrapCol([:], 5, Bootstrap4Size.XL, body)
    }

    public void colXl5(Map map, Closure body) {
        bootstrapCol(map, 5, Bootstrap4Size.XL, body)
    }

    public void colXl6(Closure body) {
        bootstrapCol([:], 6, Bootstrap4Size.XL, body)
    }

    public void colXl6(Map map, Closure body) {
        bootstrapCol(map, 6, Bootstrap4Size.XL, body)
    }

    public void colXl7(Closure body) {
        bootstrapCol([:], 7, Bootstrap4Size.XL, body)
    }

    public void colXl7(Map map, Closure body) {
        bootstrapCol(map, 7, Bootstrap4Size.XL, body)
    }

    public void colXl8(Closure body) {
        bootstrapCol([:], 8, Bootstrap4Size.XL, body)
    }

    public void colXl8(Map map, Closure body) {
        bootstrapCol(map, 8, Bootstrap4Size.XL, body)
    }

    public void colXl9(Closure body) {
        bootstrapCol([:], 9, Bootstrap4Size.XL, body)
    }

    public void colXl9(Map map, Closure body) {
        bootstrapCol(map, 9, Bootstrap4Size.XL, body)
    }

    public void colXl10(Closure body) {
        bootstrapCol([:], 10, Bootstrap4Size.XL, body)
    }

    public void colXl10(Map map, Closure body) {
        bootstrapCol(map, 10, Bootstrap4Size.XL, body)
    }

    public void colXl11(Closure body) {
        bootstrapCol([:], 11, Bootstrap4Size.XL, body)
    }

    public void colXl11(Map map, Closure body) {
        bootstrapCol(map, 11, Bootstrap4Size.XL, body)
    }

    public void colXl12(Closure body) {
        bootstrapCol([:], 12, Bootstrap4Size.XL, body)
    }

    public void colXl12(Map map, Closure body) {
        bootstrapCol(map, 12, Bootstrap4Size.XL, body)
    }
}
