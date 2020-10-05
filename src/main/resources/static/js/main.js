$(document).ready(function () {
    $(".bar").submit(function (e) {
        e.preventDefault();
        var address = $(".bar input").val().toString();
        if (str.replace(/\s/g, "") != "") {
            if ((!address.startsWith("http://")) || (!address.startsWith("https://"))) {
                address = "http://" + address;
            }
            var ua = navigator.userAgent.toString();
            $("#logo").css("text-align", "left");
            $("#logo").css("font-size", "calc(5.729166666666667vmin + 75px)");
            $(".bar").css("text-align", "left");
            $("#container").animate({paddingTop: 0}, {
                duration: 500, complete: function () {
                    $.ajax({
                        url: "/entry/",
                        type: "POST",
                        dataType: "json",
                        contentType: "application/json",
                        data: JSON.stringify({
                            address: address,
                            ua: ua,
                            counter: 0
                        }),
                        beforeSend: function () {
                            $(".loader").show();
                        },
                        success: function (data) {
                            $(".loader").hide();
                            $(".result").show();
                            res_url = "hfjohn123.tk/s/" + data._links.self.href.replace(/.+entry\//gi, "")
                            $("#res").replaceWith("<input id='res' type=\"text\" value=" + res_url + ">");
                            $("#copy").replaceWith(" <button id=\"copy\" data-clipboard-action=\"copy\" data-clipboard-text='" + res_url + "'>Copy</button>")
                        },
                        error: function (jXHR, textStatus, errorThrown) {
                            $(".loader").hide();
                            alert(textStatus.toString());
                        }
                    });
                }
            });
        }else{
            alert("Please enter a valid url");
        }
    });
});