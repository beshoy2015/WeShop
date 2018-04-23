
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
    alert("in save method");
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
    
    alert("2) in update user info js");
    
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
            alert("status is 200 salmaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//            returnToPersonalInfo();
            window.location.href = 'profile.jsp';
        }else{
            
            alert("something wrong from server");
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

