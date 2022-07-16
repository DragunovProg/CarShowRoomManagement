$(document).ready(function () {
    let rowsShown = 4;
    let orderRowsTotal = $(".order-table tbody tr").length;
    let orderNumberPages = orderRowsTotal / rowsShown;

    for (i = 0;i < orderNumberPages;i++) {
        let pageNumber = i + 1;
        $("#pagination").append('<a id="page" href="#" rel="'+i+'">'+pageNumber+'</a> ');
    }

    $('.order-table tbody tr').hide();
    $('.order-table tbody tr').slice(0, rowsShown).show();
    $('#pagination a:first').addClass('active');
    $('#pagination a').bind('click', function(){

        $('#pagination a').removeClass('active');
        $(this).addClass('active');
        var currentPage = $(this).attr('rel');
        var startItem = currentPage * rowsShown;
        var endItem = startItem + rowsShown;
        $('.order-table tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
        css('display','table-row').animate({opacity:1}, 300);
    });

})