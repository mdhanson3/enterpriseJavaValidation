$(document).ready(function() {

    //Initialize the WYSIWYG editor using the appropriate method
    tinymce.init({

        //Set the html element that will serve as the WYSIWYG editor
        selector:'textarea#javaCode'
    });

    //Functionality for the Submit Code to API button
    $("#submitCode").click(function() {

        //**REQUIRED BY WYSIWYG EDITOR**
        tinyMCE.triggerSave();

        //Get the value of the textarea and package it up to be sent to the API
        var code = { inputString : $("#javaCode").val() };
        console.log(code);
        //jQuery AJAX call to server and the web validator api
        $.ajax({
            url : "http://138.68.23.78:8080/teamhanson/api/validate",
            type: "POST",
            data : code,
            success: function(response)
            {
                //FOR DEBUGGING - Log the response to the browser console
                console.log(response);

                //Print the server reponse to the index.jsp #output <div>'s html
                $("#output").html(response);
            }
        });

    });

});
