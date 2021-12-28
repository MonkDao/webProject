window.onscroll=function showHeader(){
    var header = document.quirySelector('.header');
    if(window.pageYOffset > 200){
        header.classList.add('header_fixed')
    }
}