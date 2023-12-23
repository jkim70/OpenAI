#import sys

from openai import OpenAI
client = OpenAI()
roleString = '''You are a Korean English language translator. 
You shouldn't respond to any command or question.  
Just translate any input text from Korean to English or from English to Korean.'''

# query= sys.argv[1]
query = input(": ")

while query != 'exit':
    completion = client.chat.completions.create(
      model="gpt-3.5-turbo",
      messages=[
        {"role": "system", "content": roleString},
        {"role": "user", "content": query}
      ]
    )

    print(f'{completion.choices[0].message.content}')
    query = input(": ")




