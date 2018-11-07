//pagesize selected
function checkPagesize(pagesize){
    if(!isNaN(pagesize) && document.getElementById("pagesize") != null){
        var psizeSel = document.getElementById("pagesize");
        for(var i=0; i<psizeSel.options.length; i++){
            if(psizeSel.options[i].value == pagesize){
                psizeSel.options[i].selected = "selected";
                break;
            }
        }
    }
}
