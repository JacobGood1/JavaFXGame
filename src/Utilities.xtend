import javafx.scene.Scene
import java.util.List
import java.util.Random
import javafx.scene.shape.Line
import com.sun.javafx.charts.Legend.LegendItem
import javafx.scene.Group
import javax.swing.SpringLayout.Constraints
import javafx.scene.paint.Color

class Utilities 
{
	
	@Property Random rng = new Random
	Group gameNodes
	
	new(Group gameNodes)
	{
		this.gameNodes = gameNodes
	}
	
	int stageBoundary = 10
	def void stageBounds(Sprite sprite, Scene scene)
	{
		if(sprite.x + sprite.width > scene.width - stageBoundary)
		{
			sprite.x = scene.width - stageBoundary - sprite.width
			sprite.vx = 0
		}
		else if(sprite.x < stageBoundary)
		{
			sprite.x = stageBoundary
			sprite.vx = 0
		}
		if(sprite.y + sprite.height > scene.height - stageBoundary)
		{
			sprite.y = scene.height - stageBoundary - sprite.height
			sprite.vy = 0
		}
		else if(sprite.y < stageBoundary)
		{
			sprite.y = stageBoundary
			sprite.vy = 0
		}		
	}
	
	def dotProduct(Vector v1, Vector v2)
	{
		v1.vx * v2.dx + v1.vy * v2.dy
	}
	
	def drawVector(Vector v, Color color, int strokeW)
	{
		gameNodes.children.add(new Line => [startX = v.a.x endX = v.b.x startY = v.a.y endY = v.b.y stroke = color strokeWidth = strokeW])		
	}
	def drawVector(Vector v, Color color)
	{
		gameNodes.children.add(new Line => [startX = v.a.x endX = v.b.x startY = v.a.y endY = v.b.y stroke = color])		
	}
	def drawVector(Vector v, int strokeW)
	{
		gameNodes.children.add(new Line => [startX = v.a.x endX = v.b.x startY = v.a.y endY = v.b.y strokeWidth = strokeW])		
	}
	def drawVector(Vector v, boolean firstDraw)
	{
		gameNodes.children.add(new Line => [startX = v.a.x endX = v.b.x startY = v.a.y endY = v.b.y])		
	}
	
	def clearVectors()
	{
		val nukeLines = newArrayList
		
		gameNodes.children.forEach[child | if(child instanceof Line){nukeLines.add(child)}]
		gameNodes.children.removeAll(nukeLines)		
	}
	
	def drawVectorWithNorms(Vector v)
	{
		val leftNorm = v.leftNormal
		val rightNorm = v.rightNormal
		
		gameNodes.children.addAll
			(
				#[
					new Line => [startX = v.a.x endX = v.b.x startY = v.a.y endY = v.b.y],
					new Line => [startX = leftNorm.a.x endX = leftNorm.b.x startY = leftNorm.a.y endY = leftNorm.b.y],
					new Line => [startX = rightNorm.a.x endX = rightNorm.b.x startY = rightNorm.a.y endY = rightNorm.b.y]
				 ]
			)		
	}
	
	
	def drawVectors(Vector... vs)
	{
		vs.forEach[Vector v| gameNodes.children.add(new Line => [startX = v.a.x endX = v.b.x startY = v.a.y endY = v.b.y])]
	}
	
	def void stageWrap(Sprite sprite, Scene scene)
	{
		if(sprite.x < 0)
		{
			sprite.x = scene.width - sprite.width  
		}
		if(sprite.x + sprite.width > scene.width)
		{
			sprite.x = 0
		}
		if(sprite.y < 0)
		{
			sprite.y = scene.height - sprite.height  
		}
		if(sprite.y + sprite.height > scene.height)
		{
			sprite.y = 0
		}
	}
	
	def dx(Sprite one, Sprite two)
	{
		one.x - two.x		
	}
	def dy(Sprite one, Sprite two)
	{
		one.y - two.y
	}
	
	def distance(Sprite one, Sprite two)
	{
		val dx = one.dx(two)
		val dy = one.dy(two)
		
		Math::sqrt(dx*dx + dy*dy)
	}
	
	def map2((Object, Object) => Object fn, List<?> bs, List<?> cs)
	{
		
		val finalResult = newArrayList()
		(0..bs.length - 1).forEach[int i| finalResult.add(fn.apply(bs.get(i), cs.get(i)))]
		finalResult
	}
	
	
	def rotateToMouse(Line line, Mouse mouse)
	{
		val angle = Math::atan2(mouse.x - line.layoutX, mouse.y - line.layoutY)
		line.rotate = line.rotate + angle	
	}	
}