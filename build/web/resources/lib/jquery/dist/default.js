$(document).ready(function(){
	//code here...
	var code = $(".codemirror-textarea")[0];
	var editor = CodeMirror.fromTextArea(code, {
        lineNumbers: true,


	});
});


//EnlighterJS.init('pre', 'code','textarea', {

//    // default code indentation
//    indent: 4,

//    // &amp; to &
//    ampersandCleanup: true,

//    // enable line hover highlighting
//    linehover: true,

//    // show linenumbers
//    linenumbers: true,

//    // copy css classes from origin element to outer wrapper
//    retainCssClasses: false,

//    // additional css classes added to outer wrapper
//    cssClasses: '',

//    // top outer toolbar
//    toolbarOuter: '{BTN_TABS}',

//    // header toolbar
//    toolbarTop: '{BTN_RAW}{BTN_COPY}{BTN_WINDOW}{BTN_WEBSITE}',

//    // footer toolbar
//    toolbarBottom: '{BTN_COLLAPSE}',

//    // no line offset
//    lineoffset: 0,

//    // no special line highlighting
//    highlight: '',

//    // default layout
//    layout: 'standard',

//    // or 'scroll
//    textOverflow: 'break',

//    // enable collapse / vertical scroll
//    collapse: false,

//    // default language
//    language: 'generic',

//    // default title
//    title: '',

//  /*
//    Enlighter (enlighter, standard) - Enlighter`s default Theme
//    Classic (classic) - SyntaxHighlighter inspired
//    Bootstrap (bootstrap4) - Bootstrap 4 inpired themes, high contrast
//    Beyond (beyond) - BeyondTechnology Theme
//    Godzilla (godzilla) - A MDN inspired Theme
//    Eclipse (eclipse) - Eclipse inspired
//    MooTwo (mootwo) - Inspired by the MooTools Website
//    Droide (droide) - Modern, minimalistic
//    Minimal (minimal) - Bright, High contrast
//    Atomic (atomic) - Dark, Colorful
//    Dracula (dracula) - Dark, using official draculatheme colorscheme
//    Rowhammer (rowhammer) - Light, Transparent, divided rows
//  */
//  theme: 'enlighter',

//    // show raw code on double click
//    rawcodeDbclick: false

//});