import javafx.scene.Node

class Utilities
{
	static String collisionSide = ""
    def static collide(Node nodeA , Node nodeB)
    {
           val nodeAWidth = nodeA.boundsInLocal.width
           val nodeAHeight = nodeA.boundsInLocal.height
           val nodeBWidth = nodeB.boundsInLocal.width
           val nodeBHeight = nodeB.boundsInLocal.height
          
          
           val combinedHalfWidth = nodeAWidth / 2 + nodeBWidth / 2
           val combinedHalfHeight = nodeAHeight / 2 + nodeBHeight / 2
          
           val vx = (nodeA.layoutX + nodeAWidth / 2 ) - (nodeB.layoutX + nodeBWidth / 2 )
           val vy = (nodeA.layoutY + nodeAHeight / 2 ) - (nodeB.layoutY + nodeBHeight / 2 )
          
           if(Math ::abs( vx) < combinedHalfWidth)
           {
                  if(Math ::abs( vy) < combinedHalfHeight)
                  {
                        val overLapX = combinedHalfWidth - Math ::abs( vx)
                        val overLapY = combinedHalfHeight - Math ::abs( vy)
                       
                        println(" vx: " + overLapX + " vy : " + overLapY)
                       	true
                  }
                  else
                  {
                  	    false
                  }
           }
           else
           {
               false	 	
           }
      }
}

