<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>

<c:if test="${empty sessionScope.userInfo.email}">
                                                
    <jsp:forward page="login.jsp"></jsp:forward>
                                                
</c:if>


<html lang="zxx">
    

    <head>
        <title>Downy Shoes an Ecommerce Category Bootstrap Responsive Website Template | Shop :: w3layouts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Downy Shoes Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript">
            addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
            }, false);

            function hideURLbar() {
            window.scrollTo(0, 1);
            }
        </script>
        <script src="js/profileJs.js"></script>
        <!-- //custom-theme -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="css/shop.css" type="text/css" media="screen" property="" />
        <link href="css/style7.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Owl-carousel-CSS -->
        <link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/profile.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/shop.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/contact.css" rel="stylesheet" type="text/css" media="all" />
        <!-- font-awesome-icons -->
        <link href="css/font-awesome.css" rel="stylesheet">
        <!-- //font-awesome-icons -->
        <link href="//fonts.googleapis.com/css?family=Montserrat:100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800"
              rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
        
        <style>
            
            .inputfile{

                width: 0.1px;
                height: 0.1px;
                opacity: 0;
                overflow: hidden;
                position: absolute;
                z-index: -1;
            }

        </style>
    </head>

    <body onload="documentLoaded()">
        <!-- banner -->
        <div class="banner_top innerpage" id="home">
            <div class="wrapper_top_w3layouts">
                <div class="header_agileits">
                    <div class="logo inner_page_log">
                        <h1><a class="navbar-brand" href="index.jsp"><span>Downy</span> <i>Shoes</i></a></h1>
                    </div>
                    <div class="overlay overlay-contentpush">
                        <button type="button" class="overlay-close"><i class="fa fa-times" aria-hidden="true"></i></button>

                        <nav>
                            <ul>
                                <li><a href="index.jsp" class="active">Home</a></li>
                                <li><a href="shop.jsp">Shop Now</a></li>
                                    <c:if test="${empty sessionScope.userInfo.email}">
                                    <li><a href="login.jsp">Login</a></li>
                                    </c:if>
                                <li><a href="contact.jsp">Contact</a></li>
                                <li><a href="about.jsp">About</a></li>
                                    <c:if test="${!empty sessionScope.userInfo.email}">
                                    <li><a href="profile.jsp">Profile</a></li>
                                    <li><a href="Logout">Logout</a></li>
                                    </c:if>
                            </ul>
                        </nav>
                    </div>
                    <div class="mobile-nav-button">
                        <button id="trigger-overlay" type="button"><i class="fa fa-bars" aria-hidden="true"></i></button>
                    </div>
                    <!-- cart details -->
                    <div class="top_nav_right">
                        <div class="shoecart shoecart2 cart cart box_1">
                            <form action="#" method="post" class="last">
                                <input type="hidden" name="cmd" value="_cart">
                                <input type="hidden" name="display" value="1">
                                <button class="top_shoe_cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- //cart details -->
            <!-- search -->
            <div class="search_w3ls_agileinfo">
                <div class="cd-main-header">
                    <ul class="cd-header-buttons">
                        <li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>
                    </ul>
                </div>
                <div id="cd-search" class="cd-search">
                    <form action="#" method="post">
                        <input name="Search" type="search" placeholder="Click enter after typing...">
                    </form>
                </div>
            </div>
            <!-- //search -->
            <div class="clearfix"></div>
            <!-- /banner_inner -->
            <div class="services-breadcrumb_w3ls_agileinfo">
                <div class="inner_breadcrumb_agileits_w3">

                    <ul class="short">
                        <li><a href="index.jsp">Home</a><i>|</i></li>
                        <li>Profile</li>
                    </ul>
                </div>
            </div>
            <!-- //banner_inner -->
        </div>
        <!-- //banner -->
        

        <div class="ads-grid_shop">
            <div class="shop_inner_inf">

                <!-- profile left -->
                <div class="side-bar col-md-3">

                    <div class="shoe">
                        <div class="men-pro-item">
                            <div class="profile_img men-thumb-item">
                                <img src="${sessionScope.userInfo.img}" alt="" width="100%">
                                <div>${sessionScope.userInfo.img}</div>
                                <div class="men-cart-pro">
                                    <div class="inner-men-cart-pro">
                                        <a href="single.jsp" class="link-product-add-cart">
                                            
                                            <div class="box" style="">
                                                <!--<form enctype='multipart/form-data'>-->
                                                    <input type="file" name="image-file" id="file-1" class="inputfile inputfile-1" accept="image/*" onchange="imageChoosed(this.files)">
                                                    <label for="file-1" style=""><span style="">Upload Photo</span></label>
                                                <!--</form>-->
                                                    
                                            </div>
                                            <!--<input type="file" accept="image/*" value="Upload Photo">-->
                                        </a>
                                    </div>
                                </div>
                                <!--<span class="product-new-top">New</span>-->
                            </div>
                            <div class="item-info-product newsright">
                                <input type="button" value="Edit Profile" class="edit_profile_btn" onclick="editProfile()">
                               
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>

                    <!--                    <div>
                                            <img src="data:image/jpg;base64,${requestScope.encoded_profile_image}">   
                                            <img src="images/banner1.jpg">  
                    
                                        </div>-->

                </div>
                <!-- //product left -->
                
                
                <!-- product right -->
                <div class="left-ads-display col-md-9">
                    <div class="wrapper_top_shop">

                        <div class="container">
                            <div class="row">
                                <div class="col-md-8">
                                    <!-- Nav tabs -->
                                    <div class="card">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <!--<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>-->
                                            <!--<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>-->
                                            <li role="presentation" class="active" id="PersonalInformationTab"><a href="#PersonalInformation" aria-controls="PersonalInformation" role="tab" data-toggle="tab">Personal Information</a></li>
                                            <li role="presentation" id="BoughtProductsTab"><a href="#BoughtProducts" aria-controls="BoughtProducts" role="tab" data-toggle="tab">Bought Products</a></li>
                                            <li role="presentation" id="ChargeCreditTab"><a href="#ChargeCredit" aria-controls="ChargeCredit" role="tab" data-toggle="tab">Charge Credit</a></li>
                                        </ul>

                                        <!-- Tab panes -->
                                        <div class="tab-content">
                                            <!--<div role="tabpanel" class="tab-pane active" id="home">home - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</div>-->
                                            <!--<div role="tabpanel" class="tab-pane" id="profile"> profile - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</div>-->
                                            <div role="tabpanel" class="tab-pane active" id="PersonalInformation">
                                                
                                                <table border="0" id="user_info_table" class="user_profile_table appear">
                                                    <tr>
                                                        <td>Username :</td>
                                                        <td id="userNameVal">${sessionScope.userInfo.userName}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Email :</td>
                                                        <td id="emailVal">${sessionScope.userInfo.email}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Password :</td>
                                                        <td id="passVal">${sessionScope.userInfo.password}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Phone number :</td>
                                                        <td id="phoneVal">${sessionScope.userInfo.mobile}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Current Money :</td>
                                                        <td>$${sessionScope.userInfo.money}</td>
                                                    </tr>
                                                </table>
                                                 
                                                <div class="edit_profile_form">
                                                    
                                                    <div class="form-group row">
                                                        <label for="example-text-input" class="col-2 col-form-label">Username</label>
                                                        <div class="col-10">
                                                            <input class="form-control" type="text" value="${sessionScope.userInfo.userName}" id="userNameField" name="userNameField">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                      <label for="example-email-input" class="col-2 col-form-label">Email</label>
                                                      <div class="col-10">
                                                          <input class="form-control" type="email" value="${sessionScope.userInfo.email}" id="emailField" name="emailField">
                                                      </div>
                                                    </div>
                                                    <div class="form-group row">
                                                      <label for="example-tel-input" class="col-2 col-form-label">Phone Number</label>
                                                      <div class="col-10">
                                                          <input class="form-control" type="tel" value="${sessionScope.userInfo.mobile}" id="phoneField" name="phoneField">
                                                      </div>
                                                    </div>
                                                    <div class="form-group row">
                                                      <label for="example-password-input" class="col-2 col-form-label">Password</label>
                                                      <div class="col-10">
                                                          <input class="form-control" type="password" value="${sessionScope.userInfo.password}" id="passwordField" name="passwordField">
                                                      </div>
                                                    </div>
                                                      
                                                    <div class="form-group row">
                                                      <label for="example-password-input" class="col-2 col-form-label">Confirm Password</label>
                                                      <div class="col-10">
                                                        <input class="form-control" type="password" value="${sessionScope.userInfo.password}" id="confirmPasswordField">
                                                      </div>
                                                    </div>  
                                                    
                                                    <div class="item-info-product newsright">
                                                        <input type="button" value="Save" class="edit_profile_btn" onclick="saveInfo()">
                                                        <input type="button" value="Cancel" class="edit_profile_btn" onclick="cancelEditing()">
                                                        <div class="clearfix"></div>
                                                    </div>

                                                </div>
                                                
                                            </div>
                                                    
                                            <!--second tab content-->        
                                            <div role="tabpanel" class="tab-pane" id="BoughtProducts">
                                                
                                            </div>
                                            
                                            <!--third tab content-->        
                                            <div role="tabpanel" class="tab-pane" id="ChargeCredit">
                                                <div class="form-group row">
                                                      <label for="example-password-input" class="col-2 col-form-label">Key Card</label>
                                                      <div class="col-10 item-info-product newsright">
                                                        <input class="form-control" type="text" placeholder="Enter your key card number" id="keyCardField">
                                                        <br/>
                                                        <input type="button" id="chargeBtn" value="Charge" class="edit_profile_btn" onclick="checkCreditNum();">
                                                        <br/>
                                                        <span id="chargeResult"></span>
                                                        <!--Your account has charged successfully and your balance is ${ssessionScope.userInfo.money} -->
                                                      </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

                                                        <%@include file="footer.jsp" %>
    <a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!-- cart-js -->
    <script src="js/minicart.js"></script>
    <script>
        shoe.render();

        shoe.cart.on('shoe_checkout', function (evt) {
            var items, len, i;

            if (this.subtotal() > 0) {
                items = this.items();

                for (i = 0, len = items.length; i < len; i++) {
                }
            }
        });
    </script>
    <!-- //cart-js -->
    <!-- /nav -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/demo1.js"></script>
    <!-- //nav -->
    <!--search-bar-->
    <script src="js/search.js"></script>
    <!--//search-bar-->
    <!-- price range (top products) -->
    <script src="js/jquery-ui.js"></script>
    <script>
        //<![CDATA[ 
        $(window).load(function () {
            $("#slider-range").slider({
                range: true,
                min: 0,
                max: 9000,
                values: [50, 6000],
                slide: function (event, ui) {
                    $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
                }
            });
            $("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));

        }); //]]>
    </script>
    <!-- //price range (top products) -->

    <!-- start-smoth-scrolling -->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 1000);
            });
        });
        
        
        
        function documentLoaded(){
            
            // get all bought products 
            var productReq = null;

            if (window.XMLHttpRequest)
                productReq = new XMLHttpRequest();
            else if (window.ActiveXObject)
                productReq = new ActiveXObject(Microsoft.XMLHttp);

            productReq.onreadystatechange = handleStateChangeForGetProducts;
            productReq.open("GET", "userProfile?timeStamp=" + new Date().getTime(), true); //true means that we wil use Ajax 
            productReq.send(null);

            function handleStateChangeForGetProducts() {

                if (productReq.readyState == 4 && productReq.status == 200)
                {
//                    alert('status is 200');
                    var userProductsJson = JSON.parse(productReq.responseText);

                    var ul = "<ul>";

                    for(var i = 0 ; i < userProductsJson.length ; i++)
                    {
                        ul += "<li>"+userProductsJson[i].productName+"</li>";
                    }

                    ul+= "</ul>";

                    document.getElementById("BoughtProducts").innerHTML = ul;

                }else{
//                    alert('somehing wrong happened while getting products');
                    document.getElementById("BoughtProducts").innerText = "No products you bought yet .";
                }

            }
        }
        
        
        
//edit profile btn
function editProfile(){
    
    //active personal information tab 
    $('#PersonalInformation').addClass('active');
    $('#BoughtProducts').removeClass('active');
    $('#PersonalInformationTab').addClass('active');
    $('#BoughtProductsTab').removeClass('active');
    
    //remove the info and display the form
    $('.edit_profile_form').addClass('appear');
    $('.user_profile_table').removeClass('appear');
    
}


//save edited info
function saveInfo(){
//    alert("in save method");
    updateUserInfo();
}

function cancelEditing(){
    returnToPersonalInfo();
}

function returnToPersonalInfo(){
    
    //active personal information tab 
    $('#PersonalInformation').addClass('active');
    $('#BoughtProducts').removeClass('active');
    $('#PersonalInformationTab').addClass('active');
    $('#BoughtProductsTab').removeClass('active');
    
    //remove the info and display the form
    $('.edit_profile_form').removeClass('appear');
    $('.user_profile_table').addClass('appear');
}

function updateUserInfo(){
    
//    alert("2) in update user info js");
    
    var updateInfoReq = null;
    var userName = $('#userNameField').val();
    var email = $("#emailField").val();
    var phone = $("#phoneField").val();
    var pass = $("#passwordField").val();
    var confirmPass = $("#confirmPasswordField").val();
    var userProfileImg = $('.profile_img img').attr('src');
    
    if(window.XMLHttpRequest)
        updateInfoReq = new XMLHttpRequest();
    else if(window.ActiveXObject)
        updateInfoReq = new ActiveXObject(Microsoft.XMLHttp); 

    updateInfoReq.onreadystatechange = handleStateChangeForGetMsgs;   
    updateInfoReq.open("POST", "userProfile?timeStamp="+new Date().getTime() , true); //true means that we wil use Ajax 
    updateInfoReq.setRequestHeader("content-type","application/x-www-form-urlencoded");
    updateInfoReq.send("userNameField="+userName+"&emailField="+email+"&phoneField="+phone+"&passwordField="+pass+"&img="+userProfileImg);
 
    
    function handleStateChangeForGetMsgs(){

        if(updateInfoReq.readyState == 4 && updateInfoReq.status == 200 && updateInfoReq.responseText === "Done")
        {
//            alert("status is 200 salmaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//            returnToPersonalInfo();
            window.location.href = 'profile.jsp';
        }else{
            
//            alert("something wrong from server");
        }
    
    }
}


//uplaod image  
function imageChoosed(choosedFiles){

    var updateImgReq = null;
    var choosedImg = choosedFiles[0];
    var formdata = new FormData();
//    var userNameTd = document.getElementById("userNameVal").innerText;
//    var emailVal = document.getElementById("emailVal").innerText;
//    var passVal = document.getElementById("passVal").innerText;
//    var phoneVal = document.getElementById("phoneVal").innerText;

    if(window.XMLHttpRequest)
        updateImgReq = new XMLHttpRequest();
    else if(window.ActiveXObject)
        updateImgReq = new ActiveXObject(Microsoft.XMLHttp); 
    

    formdata.append("profile-img", choosedImg);
//    formdata.append("usernameVal" , userNameTd);
//    formdata.append("emailVal" , emailVal);
//    formdata.append("passVal" , passVal);
//    formdata.append("phoneVal" , phoneVal);

    updateImgReq.onreadystatechange = handleStateChangeForUploadImg;   
    updateImgReq.open("POST", "userProfile?timeStamp="+new Date().getTime() , true); //true means that we wil use Ajax 
//    updateImgReq.setRequestHeader("content-type","multipart/form-data;boundary=Salma");
//    updateImgReq.setRequestHeader("content-type","application/x-www-form-urlencoded");
    updateImgReq.send(formdata);
    

    function handleStateChangeForUploadImg(){

        if(updateImgReq.readyState == 4 && updateImgReq.status == 200)
        {
            window.location.href = 'profile.jsp';

//            alert(updateImgReq.responseText);
//            $('.profile_img img').attr('src' , updateImgReq.responseText)
        }

    }
   

}

function checkCreditNum(){
    
    var keyNumberInputVal = document.getElementById("keyCardField").value;
    var chargeRes = document.getElementById("chargeResult");

    var creditExpression = /^[0-9]{6}$/;
    if(keyNumberInputVal.match(creditExpression)&& keyNumberInputVal!="")
    {
        chargeRes.innerText = "valid Num";
        if(keyNumberInputVal === "123456" || keyNumberInputVal === "654321" || keyNumberInputVal === "135792" ){
            chargeUserAccount(keyNumberInputVal);
            document.getElementById("keyCardField").value = "";
        }
    }else{
        
        chargeRes.innerText = "invalid Num";

    }
}

function chargeUserAccount(creditNumber){

    var chargeReq = null;

    if(window.XMLHttpRequest)
        chargeReq = new XMLHttpRequest();
    else if(window.ActiveXObject)
        chargeReq = new ActiveXObject(Microsoft.XMLHttp); 
    

    chargeReq.onreadystatechange = handleStateChangeForChargeAccount;   
    chargeReq.open("POST", "userProfile?timeStamp="+new Date().getTime() , true); //true means that we wil use Ajax 
    chargeReq.setRequestHeader("content-type","application/x-www-form-urlencoded");
    chargeReq.send("keyNumber="+creditNumber);
    

    function handleStateChangeForChargeAccount(){
        
    var chargeResult = document.getElementById("chargeResult");
    
        if(chargeReq.readyState == 4 && chargeReq.status == 200)
        {
            if(!chargeReq.responseText.equals("Done"))
            {
                chargeResult.innerText = "The number which you have entered is invalid , please try again!";

            }else{
                
                chargeResult.innerText = "success";
            }
        }

    }

}


        
        
        
        
    </script>
    <!-- //end-smoth-scrolling -->
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
   
</body>

</html>