const className = ["디스트로이어", "워로드", "버서커", "홀리나이트", "슬레이어", "스트라이커", "브레이커", "배틀마스터", "인파이터",
                            "기공사", "창술사", "데빌헌터", "블래스터", "호크아이", "스카우터", "건슬링어", "바드", "서머너", "아르카나", "소서리스", "블레이드",
                            "데모닉", "리퍼", "소울이터", "도화가", "기상술사"];

const classIcon = ["destroyer", "warlord", "berserker", "holyknight", "berserker_female", "striker", "infighter_male", "battlemaster", "infighter", "soulmaster",
                            "lancemaster", "devilhunter", "blaster", "hawkeye", "scouter", "gunslinger", "bard", "summoner", "arcana", "sorceress", "blade", "demonic",
                            "reaper", "soul_eater", "artist", "weather_artist"];

const iconUrl = "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/";

async function getCharacterList(searchText) {
    const accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDA1MTM1MDEifQ.QB7_7pNIV2NvmPskoESH-rN5d7UDd0rToWwnyeJIIau6PpixyG1kVFVlmF8uaKz4XS_wLEj0eEs7ZgYkceFdHicYREOmrcjshtZ12diZt45sYSEaWTIe_fVgYew3DBBvamX02T7iLgRn7iJVqunMKM3SkEDzruKPIVVb_kw4L5d-wgp-W-IJD5MZ3OYyDgWI4x4SLNbEIQ_1RrmgWXgZAlCHJS--Y5C0dErPqmabCxwmUSlS0oSGQcSWRvYVhQDYAJIxmetWwkOI8uOSz3bZMuXNiBFH5BXrHWoasxfKQmzU9HrsLLePxsxVPpvqiE1yKO3D-fapHL7lBiohGYieMA"

    let characterURL = "https://developer-lostark.game.onstove.com/characters/"+ searchText + "/siblings"
    const result = await axios.get(characterURL,{
        headers: {
            Authorization: `Bearer ${accessToken}`
        }
    });// 모든 보유 캐릭터 뽑기

    const resultList = []; // 내가 장비 정보를 받아올 수 있는 애들만 resultList 에 넣을 배열.

    for(let i = 0 ; i < result.data.length ; i++){ // for문 : 모든 보유 캐릭터 돌리기
        let armoriesURL = "https://developer-lostark.game.onstove.com/armories/characters/" + result.data[i].CharacterName; // 아머리 정보 api
        const armoResult = await axios.get(armoriesURL, {
            headers : {Authorization : `Bearer ${accessToken}`}
        });
        if(armoResult.data !== null){ // 아머리 정보가 있으면
            resultList.push(result.data[i]); // resultList 에 하나씩 넣기
        }
    }
    return resultList;
}

async function getCharacter(characterName) {
    const accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDA1MTM1MDEifQ.QB7_7pNIV2NvmPskoESH-rN5d7UDd0rToWwnyeJIIau6PpixyG1kVFVlmF8uaKz4XS_wLEj0eEs7ZgYkceFdHicYREOmrcjshtZ12diZt45sYSEaWTIe_fVgYew3DBBvamX02T7iLgRn7iJVqunMKM3SkEDzruKPIVVb_kw4L5d-wgp-W-IJD5MZ3OYyDgWI4x4SLNbEIQ_1RrmgWXgZAlCHJS--Y5C0dErPqmabCxwmUSlS0oSGQcSWRvYVhQDYAJIxmetWwkOI8uOSz3bZMuXNiBFH5BXrHWoasxfKQmzU9HrsLLePxsxVPpvqiE1yKO3D-fapHL7lBiohGYieMA"

    let characterURL = "https://developer-lostark.game.onstove.com/armories/characters/" + characterName

    const result = await axios.get(characterURL, {
        headers: {
            Authorization: `Bearer ${accessToken}`
        }
    })

    console.log(result.data);
    return result.data;
}