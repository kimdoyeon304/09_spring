<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<form>
<input class="id" name="id" type="hidden">
<input class="pwd" name="pwd" type="hidden">
</form>

<script>
const id='lbi5320';
const pwd='1234';

$('.id').val(id);
$('.pwd').val(pwd);

$.ajax({
	type: "post",
	url: "post.do",
	data: $('form').serialize(),
	error: function(error){
		console.log("error");
	},
	success: function(data){
		console.log("success");
	}
});
</script>
</body>
</html>