import acavailhez.html.bootstrap.Bootstrap4Color
import org.apache.commons.lang3.StringUtils

void col(int cols, Bootstrap4Color size) {
    print """public void col${StringUtils.capitalize(size.name().toLowerCase())}${cols}(Closure body) {
         bootstrapCol([:], ${cols}, Bootstrap4Size.${size.name()}, body)
    }\n\n"""
    print """public void col${StringUtils.capitalize(size.name().toLowerCase())}${cols}(Map map, Closure body) {
         bootstrapCol(map, ${cols}, Bootstrap4Size.${size.name()}, body)
    }\n\n"""

}


Bootstrap4Color.values().each { Bootstrap4Color size ->
    for (int cols = 1; cols <= 12; cols++) {
        col(cols, size)
    }
}