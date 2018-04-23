<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<html lang="zxx">

    <head>
        <title>Downy Shoes an Ecommerce Category Bootstrap Responsive Website Template | Paymennt :: w3layouts</title>
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
        <!-- //custom-theme -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="css/shop.css" type="text/css" media="screen" property="" />
        <link href="css/style7.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Owl-carousel-CSS -->
        <link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css' />

        <link rel="stylesheet" type="text/css" href="css/checkout.css">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- font-awesome-icons -->
        <link href="css/font-awesome.css" rel="stylesheet">
        <!-- //font-awesome-icons -->
        <link href="//fonts.googleapis.com/css?family=Montserrat:100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800"
              rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
    </head>

    <body>


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
                                <li><a href="about.jsp">About</a></li>
                                <li><a href="404.jsp">Team</a></li>
                                <li><a href="shop.jsp">Shop Now</a></li>
                                <li><a href="contact.jsp">Contact</a></li>
                                    <c:if test="${empty sessionScope.userInfo.email}">
                                    <li><a href="login.jsp">Login</a></li>
                                    </c:if>
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
                        <li><a href="#">Home</a><i>|</i></li>
                        <li>Manage Users</li>
                    </ul>
                </div>
            </div>
            <!-- //banner_inner -->
        </div>

        <!-- //banner -->
        <!-- top Products -->
        <div class="ads-grid_shop">

            <div style="text-align: center">








                <div class="left-ads-display col-md-9">
                    <div class="wrapper_top_shop">
                        <div class="col-md-6 shop_left">
                            <img src="images/banner3.jpg" alt="">
                            <h6>40% off</h6>
                        </div>
                        <div class="col-md-6 shop_right">
                            <img src="images/banner2.jpg" alt="">
                            <h6>50% off</h6>
                        </div>
                        <div class="clearfix"></div>
                        <!-- product-sec1 -->
                        <div class="product-sec1">
                            <!--/mens-->








                            <!--                                                <form action="AddToCart" method="GET">
                                                                            <input type="submit" value="Pay Your Cart">
                                                                            </form>-->
                            <!-------------------------------------------------------------->
                            <form action="AddUser.jsp" method="POST">
                                <input type="submit" value="Add New User"/>
                            </form>
                            <!-------------------------------------------------------------->

                            <!-------------------------------------------------------------->

                            <!-------------------------------------------------------------->

                            <!-------------------------------------------------------------->

                            <!-------------------------------------------------------------->


                            <c:forEach var="i" begin="0" end="${sessionScope.allUsers.size()-1}">

                                <div class="col-md-4 product-men">
                                    <div class="product-shoe-info shoe">
                                        <div class="men-pro-item">                                           <div class="men-thumb-item">
                                                <img src="${sessionScope.allUsers[i].img}" alt="">
                                                <div class="men-cart-pro">
                                                    <div class="inner-men-cart-pro">
                                                        <a href="single.jsp" class="link-product-add-cart">${sessionScope.allUsers[i].id}</a>
                                                    </div>
                                                </div>
                                                <!--<span class="product-new-top">New</span>-->
                                            </div>
                                            <div class="item-info-product">


                                                <form action="deleteUser" method="POST">
                                                    <input type="hidden" name="id" value="${sessionScope.allUsers[i].id}"/>
                                                    <!--<h1>Quentity is : ${sessionScope.productsInfoAdmin[i].productQuantity}</h1>-->
                                                    <input type="button" value="DELETE" onclick="confirmDelete(${sessionScope.allUsers[i].id});"/>

                                                </form>

                                                <form action="UpdateUserData" method="POST">
                                                    <input type="hidden" name="id" value="${sessionScope.allUsers[i].id}"/>
                                                    <input type="hidden" name="userName" value="${sessionScope.allUsers[i].userName}"/>
                                                    <input type="hidden" name="password" value="${sessionScope.allUsers[i].password}"/>
                                                    <input type="hidden" name="img" value="${sessionScope.allUsers[i].img}"/>
                                                    <input type="hidden" name="email" value="${sessionScope.allUsers[i].email}"/>
                                                    <input type="hidden" name="state" value="${sessionScope.allUsers[i].state}"/>
                                                    <input type="hidden" name="mobile" value="${sessionScope.allUsers[i].mobile}"/>
                                                    <input type="hidden" name="money" value="${sessionScope.allUsers[i].money}"/>
                                                    <input type="hidden" name="creditCard" value="${sessionScope.allUsers[i].creditCard}"/>
                                                    <input type="submit" value="Update User Info"/>

                                                </form>


                                                <h4>
                                                    <a href="getUserProfileByAdmin?userId=${sessionScope.allUsers[i].id}">${sessionScope.allUsers[i].userName} </a>
                                                </h4>
<!--                                                <div class="info-product-price">
                                                    <div class="grid_meta">
                                                        <div class="product_price">
                                                            <div class="grid-price ">
                                                                <span class="money ">$675.00</span>
                                                            </div>
                                                        </div>
                                                        <ul class="stars">
                                                            <li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="shoe single-item hvr-outline-out">
                                                        <form action="#" method="post">
                                                            <input type="hidden" name="cmd" value="_cart">
                                                            <input type="hidden" name="id" value="${sessionScope.productsInfoAdmin[i].id}">
                                                            <input type="hidden" name="add" value="1">
                                                            <input type="hidden" name="shoe_item" value="${sessionScope.productsInfoAdmin[i].productName}">
                                                            <input type="hidden" name="amount" value="${sessionScope.productsInfoAdmin[i].productPrice}">
                                                            <button type="button" class="shoe-cart pshoe-cart" onclick="Add(${sessionScope.productsInfoAdmin[i].id});"><i class="fa fa-cart-plus" aria-hidden="true"></i></button>

                                                            <a href="#" data-toggle="modal" data-target="#myModal1"></a>
                                                        </form>

                                                    </div>


                                                </div>-->
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </c:forEach>



                            <div class="clearfix"></div>

                        </div>

                        <!-- //product-sec1 -->
                        <div class="col-md-6 shop_left shp">
                            <img src="images/banner4.jpg" alt="">
                            <h6>21% off</h6>
                        </div>
                        <div class="col-md-6 shop_right shp">
                            <img src="images/banner1.jpg" alt="">
                            <h6>31% off</h6>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>






            </div>



            <!-- //payment -->

            <div class="clearfix"></div>
        </div>
        <!-- //top products -->
        <div class="mid_slider_w3lsagile">
            <div class="col-md-3 mid_slider_text">
                <h5>Some More Shoes</h5>
            </div>
            <div class="col-md-9 mid_slider_info">
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class=""></li>
                        <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                        <li data-target="#myCarousel" data-slide-to="3" class=""></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="item">
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g1.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g2.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g3.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g4.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="item active">
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g5.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g6.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g2.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g1.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g1.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g2.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g3.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g4.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g1.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g2.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g3.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-3 slidering">
                                    <div class="thumbnail"><img src="images/g4.jpg" alt="Image" style="max-width:100%;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                        <span class="fa fa-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                        <span class="fa fa-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    <!-- The Modal -->

                </div>
            </div>

            <div class="clearfix"> </div>
        </div>
        <%@include file="newsLetter.jsp" %>
        <%@include file="footer.jsp" %>
    <a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>




    <script>
                                                                function confirmDelete(id)
                                                                {


                                                                    if (confirm("Are You Sure Want To Delete This Product ??"))
                                                                    {

                                                                        window.location = 'deleteUser?id=' + id;

                                                                    }


                                                                }


    </script>







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
    <!-- easy-responsive-tabs -->
    <script src="js/easy-responsive-tabs.js"></script>
    <script>
                                                                $(document).ready(function () {
                                                                    $('#horizontalTab').easyResponsiveTabs({
                                                                        type: 'default', //Types: default, vertical, accordion           
                                                                        width: 'auto', //auto or any width like 600px
                                                                        fit: true, // 100% fit in a container
                                                                        closed: 'accordion', // Start closed if in accordion view
                                                                        activate: function (event) { // Callback function if tab is switched
                                                                            var $tab = $(this);
                                                                            var $info = $('#tabInfo');
                                                                            var $name = $('span', $info);
                                                                            $name.text($tab.text());
                                                                            $info.show();
                                                                        }
                                                                    });
                                                                    $('#verticalTab').easyResponsiveTabs({
                                                                        type: 'vertical',
                                                                        width: 'auto',
                                                                        fit: true
                                                                    });
                                                                });
    </script>

    <!-- credit-card -->
    <script type="text/javascript" src="js/creditly.js"></script>
    <link rel="stylesheet" href="css/creditly.css" type="text/css" media="all" />

    <script type="text/javascript">
                                                                $(function () {
                                                                    var creditly = Creditly.initialize(
                                                                            '.creditly-wrapper .expiration-month-and-year',
                                                                            '.creditly-wrapper .credit-card-number',
                                                                            '.creditly-wrapper .security-code',
                                                                            '.creditly-wrapper .card-type');

                                                                    $(".creditly-card-form .submit").click(function (e) {
                                                                        e.preventDefault();
                                                                        var output = creditly.validate();
                                                                        if (output) {
                                                                            // Your validated credit card output
                                                                            console.log(output);
                                                                        }
                                                                    });
                                                                });
    </script>
    <!-- //credit-card -->


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
    </script>
    <!-- //end-smoth-scrolling -->
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>


</body>

</html>