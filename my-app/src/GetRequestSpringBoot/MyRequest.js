import React from 'react'
import axios from 'axios'

const MY_URL = 'http://192.168.0.103:7700/greeting';
const MY_URL2 = 'http://192.168.0.103:7700/greeting2';
const MY_URL_LogIn = 'http://192.168.0.103:7700/login';
const MY_URL_POST = 'http://192.168.0.103:7700/add';

class MyRequest extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            mess: [],
            newMess: [],
            username: "test",
            age: 10
        };

        this.postMyForm=this.postMyForm.bind(this);
    }



    postMyForm(e) {
        e.preventDefault();

        const data= new FormData(e.target)
        console.log(data.get('username'))
        const newUser = {
            username: data.get('username'),
            age: data.get('age')
        };
        console.log("new user:"+this.state.username+" "+newUser.age);

        return axios.post(MY_URL_POST, newUser).then((data) => {
            console.log("post response");
            console.log(data.data)

        })
    }

    getMessage() {
        return axios.get(MY_URL)
            .then((data) => {
                this.setState({mess: data.data});

            });
    }

    getLogIn() {
        return axios(MY_URL_LogIn).then((log) => {
            console.log(log.data)
        });
    }

    getNewMessage() {
        alert("ok")
        return axios.get(MY_URL2)
            .then((res) => {
                this.setState({newMess: res.data});
            });
    }

    resetMessage() {
        if (this.state.mess != null) {
            this.setState({mess: null});
        }

        if (this.state.newMess != null) {
            this.setState({newMess: null});
        }

    }

    render() {

        return (
            <div>
                <div>
                    <form
                          onSubmit={this.postMyForm}>
                        <label >Name
                        <input type="text" name="username"
                               // value={this.state.username}
                              /></label>
                        <label >Age
                        <input type="number" name="age"
                               // value={this.state.age}
                              /></label>
                        <button type="submit">Submit</button>
                    </form>
                </div>

                <div>
                    <button type="button" onClick={this.getMessage.bind(this)}>First Message</button>
                    <p>This my message {this.state.mess}</p>
                </div>

                <section>
                    <button type="button" onClick={this.getNewMessage.bind(this)}>Second Message</button>
                    <p>This other message {this.state.newMess}</p>
                </section>
                <div>
                    <button type="button" onClick={this.resetMessage.bind(this)}>Clear</button>
                </div>

            </div>
        );
    }
}

export default MyRequest;