
  

<input type="hidden" id="pageparams" name="pageparams" >
<script type="text/javascript">
    var urlIndex = document.URL.indexOf("?");
    var pVal = "";
    if(urlIndex == -1){
        document.getElementById("pageparams").value = "";
    }else{
        var params = document.URL.replace(document.URL.substring(0,urlIndex+1), "");
        var index = params.indexOf("pagesize");
        if(index == -1){
            pVal = "&"+params;
        }else if(index==0){ 
            var index2 = params.indexOf("&");
            if(index2 != -1){
                pVal = params.replace(params.substring(0, index2), "");
            }else{
                pVal = "";
            }
        }else{ 
            var index3 = params.indexOf("&pagesize")
            if(index3 == -1){
                pVal = "&" + params;
            } else {
                pVal = "&"+params.replace(params.substring(index3), "")
            }
        }
        document.getElementById("pageparams").value = pVal;
    }
</script>