/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function paging(id, pageindex, totalpage, gap)
{
    var container = document.getElementById(id);
    var result = '';
    if (pageindex - gap > 1)
        result += '<a href="invoice?page=1">' + '<button>' + 'First' + '</button>' + '</a>';

    for (var i = pageindex - gap; i < pageindex; i++)
        if (i > 0)
            result += '<a href="invoice?page=' + i + '">' + '<button>' + i + '</button>' + '</a>';

    result += '<button>'+ '<span>'  + pageindex  + '</span>'+ '</button>';

    for (var i = pageindex + 1; i <= pageindex + gap; i++)
        if (i <= totalpage)
            result += '<a href="invoice?page=' + i + '">' + '<button>' + i + '</button>' + '</a>';

    if (pageindex + gap < totalpage)
        result += '<a href="invoice?page=' + totalpage + '">' + '<button>' + 'Last' + '</button>' + '</a>';

    container.innerHTML = result;
}


