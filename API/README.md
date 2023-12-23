### Basic of Using API
https://platform.openai.com/docs/quickstart?context=python 

Set an environment variable
```
export OPENAI_API_KEY="sk-xlGXXXXXXXXBHGFCVGNBHBBG....."
```
Activate Open-AI environment

```console
jihwan@jihwan-950XED:~/CodingOnGit/OpenAI/API$ ls
openai-translator.py  openapi-env  README.md
jihwan@jihwan-950XED:~/CodingOnGit/OpenAI/API$ source openapi-env/bin/activate
(openapi-env) jihwan@jihwan-950XED:~/CodingOnGit/OpenAI/API$
```

#### openai-translator.py
```console
(openapi-env) jihwan@jihwan-950XED:~/CodingOnGit/OpenAI/API$ python openai-translator.py 
: I hope OpenAI translates it correctly
나는 OpenAI가 올바르게 번역해주기를 바랍니다. (I hope OpenAI translates it correctly.)
: The weather is nice but cold
날씨는 좋지만 춥습니다.
: 날시가 좋지만 추운 날입니다
The weather is nice, but it's cold.
: 한국과 일본의 시간 차이가 있나요?
Is there a time difference between Korea and Japan?
: exit
(openapi-env) jihwan@jihwan-950XED:~/CodingOnGit/OpenAI/API$ 
```