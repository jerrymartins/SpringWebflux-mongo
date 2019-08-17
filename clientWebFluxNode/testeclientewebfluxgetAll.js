const fetch = require("node-fetch");

getUsers = async () => {
	let randomStringForName = Math.random().toString(36).substring(7);

    const settings = {
        method: 'GET',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        }
    };
    try {
        const fetchResponse = await fetch('http://localhost:8080/users/all', settings);
        const data = await fetchResponse.json();
        console.log(data);
        return data;
    } catch (e) {
    	console.log(e)
        return e;
    }    

}

setInterval(() => getUsers(), 10000);
