var React = require('react');
var createReactClass = require('create-react-class');
var Link = require('react-router').Link;

module.exports = createReactClass({
	displayName: 'login_layout',
	render: function() {
		var custom = this.props.custom;
		return(
			<html>
				<head>
					<title>{custom.title}</title>
					<link rel="stylesheet" href="./static/css/login.css" />
				</head>
				<body>
					<div className="content">
						<h1>{custom.head}</h1>
						{this.props.children}
						<p><Link to='/'>Customer Login</Link></p>
						<p><Link to='/seller'>Seller Login</Link></p>
					</div>
					<script dangerouslySetInnerHTML={{
						__html: 'window.PROPS=' + JSON.stringify(custom)
					}} />
					<script src='/bundle.js' />
				</body>
			</html>
		);
	}
});