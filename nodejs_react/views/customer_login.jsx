var React = require('react');
var createReactClass = require('create-react-class');
var ReactDOM = require('react-dom');
var axios = require('axios');
var serialize = require('form-serialize');

module.exports = createReactClass({
	displayName: 'customer_login',
	_handleswitch: function(event) {
		event.preventDefault();
		location.pathname = "/dash";
	},
	_handlelogin: function(event) {
		event.preventDefault();
		if (this.refs.username.value === "" || this.refs.password.value === "") {
			this.setState({ errormessage: "please fill in required input" });
		} else {
			var loginform = ReactDOM.findDOMNode(this.refs.loginform);
			var data = serialize(loginform);
			this.setState({ errormessage: "" });
			axios({
				method: "post",
				url: "http://localhost:3000/api/login",
				data: data
			})
			.then((response) => {
				if (response.data["msg"] !== null) {
					ReactDOM.findDOMNode(this.refs.username).value = "";
					ReactDOM.findDOMNode(this.refs.password).value = "";
					alert("invalid login plaese try again");
					//<form className="form-signin" action="http://localhost:3000/api/login" method="post">
				} else {
					location.pathname = "/dash";
				}
			});
		}
	},
	getInitialState: function() {
		return {
			errormessage: ""
		};
	},
	render: function() {
		return(
			<div>
				<form onSubmit={this._handlelogin} ref="loginform">
					<p>{this.state.errormessage}</p>
					<p>username</p>
					<p><input type="text" name="username" className="form-control" placeholder="username" ref="username" /></p>
					<p>password</p>
					<p><input type="password" name="password"  className="form-control" placeholder="password" ref="password" /></p>
					<button onClick={this._handlelogin} className="signinbtn">Login</button>
					<button className="switchbtn" onClick={this._handleswitch}>Shop Now!</button>
				</form>
			</div>
		);
	}
});