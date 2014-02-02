var chatAvailable;
window.onload = showHideChat();
window.setTimeout("receive();", 1000);
function showHideChat()
{
    if(document.getElementById('checkbox').checked)
    {   
        document.getElementById('chatWindow').style.display="block";
        chatAvailable = true;
        receive();
    }
    else
    {
        document.getElementById('chatWindow').style.display="none";
		chatAvailable = false;
    }
}

function send()
{
    var message = document.getElementById('message').value;
    var nick = document.getElementById('nick').value;
	
    if(nick.length == 0 || nick.length > 15 )
        alert("wprowadź nazwę użytkownika.");    
	else if(message.length == 0 || message.length > 100)
		alert("zbyt długa wiadomość lub jej brak");
    else
    {
        newMessage = new XMLHttpRequest();
        newMessage.open("GET","send.php?nick="+nick+"&message="+message, true);
        newMessage.send();
    }
}

function receive()
{
	if(chatAvailable)
	{
		request = new XMLHttpRequest();   
		request.onreadystatechange = function() 
		{
			if(request.readyState == 3 && request.status == 200)
			{
				document.getElementById('textArea').value = request.responseText;
			}
			if(request.readyState == 4 && request.status == 200)
			{
				request.open("GET","receive.php", true);
				request.send();
			}
		}
		request.open("GET","receive.php", true);
		request.send();
	}
}