import React from 'react'
import MyTest from "./MyTest/MyTest";
import MyNewTest from "./NewTest/MyNewTest";
import MyRequest from "./GetRequestSpringBoot/MyRequest";

function App() {
    return (
        <div className="wrapper">
            <p>Kotlin react</p>
            <a href="http://localhost:7700/greeting">link</a>
            <MyTest/>
            <TestMy name="React"/>
            <MyNewTest/>
            <MyRequest/>
        </div>
    );
}

export default App;

class TestMy extends React.Component {
    render() {
        return (
            <div>
                <h1>This is Kotlin and {this.props.name}</h1>
            </div>
        );
    }
}

