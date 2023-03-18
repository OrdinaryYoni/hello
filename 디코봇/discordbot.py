import discord
from discord.ext import commands
 

token ='MTA4NjUzMDk2Mjk0MDI0NDA1MA.G74ha4.EFfpyULSVhfUSXWIh6i6tF9UIa-rI9tRYOODN8'
@app.event
async def on_ready():
    print('Done')
    await app.change_presence(status=discord.Status.online, activity=None)

@app.command()
async def hello(ctx):
    await ctx.send('Hello I am Bot!')
    
app.run(token)
