<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
</head>
<body>
	<section class="section">
	<div class="container">
		<h1 class="title">Sentiment Analyzer</h1>
		<p class="subtitle">This tool is going to analyze your input and
			show percentage and type of sentiment.</p>

		<form action="sentiment" method="post">
			<div class="field">
				<div class="control">
					<textarea class="textarea" name="message"></textarea>
				</div>
				<p class="help">Please enter any message to analyze sentiment
					score.</p>
			</div>

			<div class="field is-grouped">
				<div class="control">
					<button class="button is-link">Submit</button>
				</div>
			</div>
		</form>
	</div>
	</section>


	<section class="hero">
	<div class="hero-body">
		<div class="container">
			<h2 class="subtitle">Result of Sentimental</h2>
			<c:if test="${not empty type }">
				<p>Sentiment Type: ${type}</p>
			</c:if>
			<c:if test="${ not empty score }">
				<p>Sentiment Score: ${score}</p>
			</c:if>
			<c:if test="${ not empty veryPositive }">
				<p>Very Positive Percentage: %${veryPositive}</p>
			</c:if>
			<c:if test="${ not empty positive }">
				<p>Positive Percentage: %${positive}</p>
			</c:if>
			<c:if test="${ not empty neutral }">
				<p>Neutral Percentage: %${neutral}</p>
			</c:if>
			<c:if test="${ not empty negative }">
				<p>Negative Percentage: %${negative}</p>
			</c:if>
			<c:if test="${ not empty veryNegative }">
				<p>Very Negative Percentage: %${veryNegative}</p>
			</c:if>
		</div>
	</div>
	</section>


	<footer class="footer">
	<div class="container">
		<div class="content has-text-centered">
			<p>
				<strong>Sentiment Analyzer</strong> by Emirhan Kemal KÖSEM. The
				source code is licensed <a
					href="http://opensource.org/licenses/mit-license.php">MIT</a>.
			</p>
		</div>
	</div>
	</footer>

</body>
</html>