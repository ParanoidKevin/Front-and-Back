var React = require('react');
var createReactClass = require('create-react-class');

module.exports = createReactClass({
	displayName: 'seller_login',
	_handlelogin: function() {
		console.log(this.refs.username.value);
	},
	render: function() {
		return(
			<div>
				<p>username</p>
				<p><input type="text" placeholder="username" ref="username" /></p>
				<p>password</p>
				<p><input type="password" placeholder="password" ref="password" /></p>
				<button onClick={this._handlelogin}>Login</button>
			</div>
		);
	}
});