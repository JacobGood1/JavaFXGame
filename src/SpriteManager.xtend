import java.util.List
import javafx.collections.ObservableList
import javafx.collections.FXCollections
import java.util.Set

class SpriteManager 
{
	
	List<Sprite> CHECK_COLLISION_LIST = newArrayList
	Set<Sprite> CLEAN_UP_SPRITES_LIST = newHashSet
	
	ObservableList<Sprite> GAME_SPRITES_ON_CURRENT_SCENE_LIST = FXCollections::observableList(newArrayList)
	
	def getSprites()
	{
		GAME_SPRITES_ON_CURRENT_SCENE_LIST
	}
	
	def getCleanUpSpritesList()
	{
		CLEAN_UP_SPRITES_LIST
	}
	
	def addSprites(Sprite... sprites)
	{
		GAME_SPRITES_ON_CURRENT_SCENE_LIST.addAll(sprites)
	}
	
	def	removeSprites(Sprite... sprites)
	{
		GAME_SPRITES_ON_CURRENT_SCENE_LIST.removeAll(sprites)
	}
	
	def getSpritesToBeRemoved()
	{
		CLEAN_UP_SPRITES_LIST
	}
	
	def addSpritesToBeRemoved(Sprite... sprites)
	{
		switch(sprites)
		{
			case sprites.length > 1 : CLEAN_UP_SPRITES_LIST.addAll(sprites)
			default                 : CLEAN_UP_SPRITES_LIST.add(sprites.get(0))
		}
	}
	
	def getCollisionsToCheck()
	{
		//println(GAME_SPRITES_ON_CURRENT_SCENE_LIST)
		CHECK_COLLISION_LIST
	}
	
	def resetCollisionsToCheck()
	{
		CHECK_COLLISION_LIST.clear
		CHECK_COLLISION_LIST.addAll(GAME_SPRITES_ON_CURRENT_SCENE_LIST)
	}
	
	def cleanUpSprites()
	{
		removeSprites(CLEAN_UP_SPRITES_LIST)
		CLEAN_UP_SPRITES_LIST.forEach[sprite| sprite.terminate]
		CLEAN_UP_SPRITES_LIST.clear
	}	
}