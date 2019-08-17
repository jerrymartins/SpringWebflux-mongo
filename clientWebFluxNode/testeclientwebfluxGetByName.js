const fetch = require("node-fetch");

getUsers = async (user) => {
	let randomStringForName = Math.random().toString(36).substring(7);

    const settings = {
        method: 'GET',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        }
    };
    try {
    	let start_time = new Date().getTime();
        const fetchResponse = await fetch(`http://localhost:8080/users/findByName?nameClient=${user}`, settings);
        const data = await fetchResponse.json();
        console.log('Time elapsed:', new Date().getTime() - start_time);
        console.log(data);
        return data;
    } catch (e) {
    	console.log(e)
        return e;
    }    

}

//setInterval(() => getUsers(), 10000);
const users = ['0rgwkk', 'v5osfa', 'oi063h', 'ytlm15', 'f84k2e', 'vceaa', 'ok'];

users.forEach( user => getUsers(user));



