const dev = {
    url: {
        BASE_URL: 'http://localhost:8080'
    }
}

const producao = {
    url: {
        BASE_URL: '#'
    }
}

export const config = process.env.NODE_ENV === 'development' ? dev : producao