const fetch = require("node-fetch");

postUsers = async () => {
	let randomStringForName = Math.random().toString(36).substring(7);

    const settings = {
        method: 'POST',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
							  "age": 10,
							  "name": randomStringForName
							 })
    };
    try {
        const fetchResponse = await fetch('http://localhost:8080/users', settings);
        const data = await fetchResponse.json();
        console.log(data);
        return data;
    } catch (e) {
    	console.log(e)
        return e;
    }    

}

setInterval(() => postUsers(), 20);
setInterval(() => postUsers(), 40);
setInterval(() => postUsers(), 50);
setInterval(() => postUsers(), 60);
setInterval(() => postUsers(), 70);
setInterval(() => postUsers(), 80);
setInterval(() => postUsers(), 90);
