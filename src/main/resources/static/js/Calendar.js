async function getCalendars() {

    const accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDA1MTM1MDEifQ.QB7_7pNIV2NvmPskoESH-rN5d7UDd0rToWwnyeJIIau6PpixyG1kVFVlmF8uaKz4XS_wLEj0eEs7ZgYkceFdHicYREOmrcjshtZ12diZt45sYSEaWTIe_fVgYew3DBBvamX02T7iLgRn7iJVqunMKM3SkEDzruKPIVVb_kw4L5d-wgp-W-IJD5MZ3OYyDgWI4x4SLNbEIQ_1RrmgWXgZAlCHJS--Y5C0dErPqmabCxwmUSlS0oSGQcSWRvYVhQDYAJIxmetWwkOI8uOSz3bZMuXNiBFH5BXrHWoasxfKQmzU9HrsLLePxsxVPpvqiE1yKO3D-fapHL7lBiohGYieMA"

    const result = await axios.get(`https://developer-lostark.game.onstove.com/gamecontents/calendar`,{
        headers: {
            Authorization: `Bearer ${accessToken}`
        }
    });

    return result.data;
}
