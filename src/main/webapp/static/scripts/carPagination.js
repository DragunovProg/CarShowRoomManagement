$(document).ready(function () {
    let rowsShown = 4;
    let carsRowsTotal = $(".cars-table tbody tr").length;
    let carsNumberPages = carsRowsTotal / rowsShown;

    for (i = 0;i < carsNumberPages;i++) {
        let pageNumber = i + 1;
        $("#pagination-cars").append('<a id="page-cars" href="#" rel="'+i+'">'+pageNumber+'</a> ');
    }

    $('.cars-table tbody tr').hide();
    $('.cars-table tbody tr').slice(0, rowsShown).show();
    $('#pagination-cars a:first').addClass('active');
    $('#pagination-cars a').bind('click', function(){

        $('#pagination-cars a').removeClass('active');
        $(this).addClass('active');
        var currentPage = $(this).attr('rel');
        var startItem = currentPage * rowsShown;
        var endItem = startItem + rowsShown;
        $('.cars-table tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
        css('display','table-row').animate({opacity:1}, 300);
    });

})