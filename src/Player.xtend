import javafx.scene.Scene
import javafx.scene.Group
import javafx.scene.input.KeyEvent
import javafx.scene.input.KeyCode
import java.util.List

class Player extends Sprite
{
	boolean fart = false
	val controls = #{
	                 'w' -> KeyCode::W, 
	                 'a' -> KeyCode::A, 
	                 's' -> KeyCode::S, 
	                 'd' -> KeyCode::D
	                }
	
	List<KeyCode> keyPresses = newArrayList
	
	new(Scene gameSurface, Group gameNodes, SpriteManager spriteManager, Utilities util, Assets ass) 
	{
		super(gameSurface, gameNodes, spriteManager, util, ass)
		appearance = player
		SPEED = 10
		
		id = "player"
		
		TERMINAL_VELOCITY = 2
		TERMINAL_FRICTION = 2
		friction = 0
		
		gameSurface.onKeyPressed = [keyDown] 
		gameSurface.onKeyReleased = [keyUp]
		
		
	}
	
	
	override collision() 
	{
				
	}
	
	def toInteger(Object a)
	{
		a.hashCode
	}
	
	override terminate()
	{
		spriteManager.removeSprites(this)
		gameNodes.children.remove(appearance)	
	}
	
	//player specific movement methods
	def code(KeyCode code, String keyBoardKey)
	{
		code == controls.get(keyBoardKey)
	}
	def keyDown(KeyEvent ke)
	{
		fart = true
		if(!keyPresses.contains(ke.code))
		{
			keyPresses.add(ke.code)
		}		
	}
	def keyUp(KeyEvent ke)
	{
		val code = ke.code
		keyPresses.remove(code)
		if(code.code('w')){acceleration = 0}
		fart = false		
	}
	
	override personalUpdate() 
	{
		keyPresses.forEach[currentKey | 
			if(currentKey.code('w')){acceleration = acceleration + SPEED this.marioFart}
			else if(currentKey.code('a')){rotate(-3)}
			else if(currentKey.code('d')){rotate(3)}
		]
		
		
		val angle = appearance.rotate * Math::PI/180
		accelerationX = Math::cos(angle) * acceleration 
		accelerationY = Math::sin(angle) * acceleration
		
		if(!fart)
		{
			if(Math::abs(vx) < 0.1 && Math::abs(vy) < 0.1)
			{
				accelerationX = 0
				accelerationY = 0
				frictionX = 0
				frictionY = 0
			}	
		}
		
	}
	
}