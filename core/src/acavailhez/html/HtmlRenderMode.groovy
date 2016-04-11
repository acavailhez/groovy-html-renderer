package acavailhez.html

enum HtmlRenderMode {
    IMMEDIATE, // rendered with the page
    ON_READY, // asked when the page is loaded
    ON_REQUEST // when a specific js is launched
}
