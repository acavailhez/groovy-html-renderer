import acavailhez.html.traits.bootstrap.Bootstrap4Size
import org.apache.commons.lang3.StringUtils

void col(int cols, Bootstrap4Size size) {
    print """public void col${StringUtils.capitalize(size.name().toLowerCase())}${cols}(Closure body) {
         bootstrapCol(${cols}, Bootstrap4Size.${size.name()}, body)
    }\n\n"""

}


Bootstrap4Size.values().each { Bootstrap4Size size ->
    for (int cols = 1; cols <= 12; cols++) {
        col(cols, size)
    }
}