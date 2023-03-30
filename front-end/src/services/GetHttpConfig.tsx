const getHttpConfig = (): any => {
    return {
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Header' : '*'
        },
    }
}

export default getHttpConfig;