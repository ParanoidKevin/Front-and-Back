var React = require('react');
var createReactClass = require('create-react-class');
var Link = require('react-router').Link;
var ReactDOM = require('react-dom');
var axios = require('axios');
var serialize = require('form-serialize');

module.exports = createReactClass({
    displayName: 'mystore',
    getInitialState() {
		return {
            src: "",
            content: ""
		};
    },
    _upload: function(event) {
        this.setState({
            src: URL.createObjectURL(event.target.files[0]),
            content: event.target.files[0]
        });
    },
    _handlefileupload: function(event) {
        event.preventDefault();
        var formData = new FormData();
        formData.append("fileToUpload", this.state.content); //这个很重要！！！fileToUpload跟后台的RequestParam名字要对的上
        axios({
            method: "post",
            url: "http://localhost:3000/api/testuploadimg",
            data: formData,
            headers: {
               'content-type': 'multipart/form-data;boundary=gc0p4Jq0M2Yt08jU534c0p'
            }
        })
        .then((response) => {
            if (response.data === "success") {
                alert("file uploaded!");
            } else {
                alert("server error pleases try again");
            }
        })
        .catch((error) => {
            alert(error);
        });
    },
	render: function() {
        var custom = "";
		return(
			<html>
				<head>
					<title>webshop CRM</title>
				</head>
				<body>
                    <h1>Welcome to test CRM</h1>
                    <p>test upload a image</p>
                    <form encType="multipart/form-data" action="http://localhost:3000/api/testuploadimg" method="post" ref="fileupload" onSubmit={this._handlefileupload}>
                        <input type="file" onChange={this._upload} name="fileToUpload" ref="file" />
                        <button onClick={this._handlefileupload}>File Submit</button>
                    </form>
                    <script dangerouslySetInnerHTML={{
						__html: 'window.PROPS=' + JSON.stringify(custom)
					}} />
					<script src='/bundle.js' />
				</body>
			</html>
		);
	}
});