import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.Group
import javafx.util.Duration
import javafx.geometry.Rectangle2D
import javafx.scene.media.AudioClip

@Data class Assets 
{
	Group gameNodes
	
	new(Group gameNodes)
	{
		this._gameNodes = gameNodes
	}
	private Image playerImage = new Image("images/player.png")
	ImageView player = new ImageView => [image = playerImage fitWidth = 50 fitHeight = 50] 
	
	private Image marioFartCloud = new Image("http://gushh.net/blog/wp-content/uploads/2011/06/smoke_1_40_128_corrected.png")	
	private AudioClip gasAttack = new AudioClip("http://soundbible.com/grab.php?id=1312&type=mp3")
	
	private Image BACKGROUND = new Image("http://t0.gstatic.com/images?q=tbn:ANd9GcQjBZlPyHD7CYZRNchCgVk_c_88Zhl2bJkAKBpe7TgGeqegBxYE2g")
	private ImageView background = new ImageView => [image = BACKGROUND]
	
	private Image STAR = new Image("http://t0.gstatic.com/images?q=tbn:ANd9GcQjBZlPyHD7CYZRNchCgVk_c_88Zhl2bJkAKBpe7TgGeqegBxYE2g")
	
	def ImageView star()
	{
		new ImageView => [image = STAR]	
	}
	
	val Image ENEMY = new Image("http://www.web2generators.com/application/img/sprite-sample.png")
	val enemy = [|new ImageView => [image = ENEMY viewport = new Rectangle2D(100,100,50,50)]]
	
	def marioFart(Sprite sprite)
	{
		//gasAttack.play
		val fart = [|new ImageView => 
			[
				image = marioFartCloud 
				layoutX = sprite.x - sprite.width
				layoutY = sprite.y - (sprite.height + sprite.height / 2) 
				viewport = new Rectangle2D(0,0,128,128)
			]
		]
		val fartSprites = fart.apply
		gameNodes.children.add(fartSprites)
		
		val fartAnim = new SpriteAnimation(fartSprites,Duration::millis(1000),8*4+5,8,0,0,128,128) => 
		[
			cycleCount = 1
			onFinished = [fartSprites.visible = false gameNodes.children.remove(fartSprites)]
		]	
		fartAnim.play
	}
	
	
	
	
	/*private val animationBombExplosionImage = [|new ImageView => 
	[ 
		image = explosion
		viewport = new Rectangle2D(0,0,64,64)
		//set layout x and y to the current position of the dead bomb
	]]
																											
	@Property val animationBombExplosion = 
	[
		Bomb bomb, Group gameNodes |
		
		val explosion = animationBombExplosionImage.apply => [layoutX = bomb.displayNode.layoutX layoutY = bomb.displayNode.layoutY]
		gameNodes.children.add(explosion) 
		
		boom.play 
		                         //                                       count, columns, offsetX, offsetY, spriteSizeX, spriteSizeY
		val anim = new SpriteAnimation(explosion, Duration::millis(1000),    25,       5,       0,       0,          64,          64) => 
			[
				cycleCount = 1 
				onFinished = [explosion.visible = false gameNodes.children.remove(explosion)]
			]
		anim.play
	]*/	
}