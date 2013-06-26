import java.util.List
import java.util.HashSet

class SpriteManager 
{
	List<Sprite> GAME_SPRITES = newArrayList
	List<Sprite> CHECK_COLLISION_LIST = newArrayList
	HashSet<Sprite> CLEAN_UP_SPRITES = newHashSet
	
	def getSprites()
	{
		GAME_SPRITES
	}
	
	def addSprites(Sprite... sprites)
	{
		GAME_SPRITES.addAll(sprites)	
	}
	
	def	removeSprites(Sprite... sprites)
	{
		GAME_SPRITES.removeAll(sprites)
	}
	
	def getSpritesToBeRemoved()
	{
		CLEAN_UP_SPRITES
	}
	
	def addSpritesToBeRemoved(Sprite... sprites)
	{
		if(sprites.length > 1)
		{
			CLEAN_UP_SPRITES.addAll(sprites)	
		}	
		else
		{
			CLEAN_UP_SPRITES.add(sprites.get(0))
		}
	}
	
	def getCollisionsToCheck()
	{
		CHECK_COLLISION_LIST
	}
	
	def resetCollisionsToCheck()
	{
		CHECK_COLLISION_LIST.clear
		CHECK_COLLISION_LIST.addAll(GAME_SPRITES)
	}
	
	def cleanupSprites(GameWorld world)
	{
		CLEAN_UP_SPRITES.forEach[s | s.displayNode.visible = false]
		GAME_SPRITES.removeAll(CLEAN_UP_SPRITES)
		CLEAN_UP_SPRITES.clear
	}	
}