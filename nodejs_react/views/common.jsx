var React = require('react');
var createReactClass = require('create-react-class');
var Link = require('react-router').Link;
var ReactDOM = require('react-dom');
var axios = require('axios');


module.exports = createReactClass({
	displayName: 'common',
	_handleToSignIn: function() {
		location.pathname = "/login";
	},
	_toMyStore: function() {
		
	},
	/*
	getInitialState() {
		return {
			map: ""
		};
	},
	*/
	componentDidMount() {
		axios.get("http://localhost:3000/api/getAllMenu").then((res) => {
			var node = ReactDOM.findDOMNode(this.refs.test);
			var result = "";
			result += "<table id='customers' class='test'>";
			result += "<tr>";
			result += "<th>";
			result += "<dl>";
			for (var catalogue in res.data) {
				result += "<dt>" + catalogue + "</dt>";
				for (var sub in res.data[catalogue]) {
					result += "<dd><a href=" + res.data[catalogue][sub] + ">" + sub + "</a></dd>";
				}
			}
			result += "</dl>";
			result += "</th>";
			result += "</tr>";
			result += "</table>";
			node.innerHTML += result;
		})
		.catch((error) => {
			console.log(error);
		});
	},
	render: function() {
		var custom = this.props.custom;
		return(
			<html>
				<head>
					<meta charSet="utf-8" />
					<title>{custom.title}</title>
					<link rel="stylesheet" href="./static/css/dash.css" />
					<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0"/>
				</head>
				<body>
					<div>
						<div className="commonarea">
							<img src="./static/images/logo.png" className="logo"/>
							<h1 className="subtitle">{custom.head}</h1>					
							<input type="text" name="searchInput" className="dashsearchbar" placeholder="search" ref="searchInput" size="50" />
							<button className="storebtn" onClick={this._toMyStore}>My Store</button>
							<button className="signinbtn" onClick={this._handleToSignIn}>Sign In</button>
							<button className="profilebtn">My Profile</button>
						</div>
						<hr />
						<div className="content">
							<div ref="test"/>
							<div className="children">
								{this.props.children}
							</div>
						</div>
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