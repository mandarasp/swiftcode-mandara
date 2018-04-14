package services;

import data.FeedResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import play.libs.ws.WS;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class FeedService {
 public FeedResponse getFeedByQuery(String query){
     FeedResponse myfeedresponse= new FeedResponse();
     try{
         WSRequest queryRequest=WS.url("http://news.google.com/news");
         CompletionStage<WSResponse> responsePromise = queryRequest
                    .setQueryParameter("q","srh")
                    .setQueryParameter("output","rss")
                    .get();
     Document feedresponse =responsePromise.thenApply(WSResponse::asXml).toCompletableFuture().get();
     Node item=feedresponse.getFirstChild().getChildNodes().item(10);
     myfeedresponse.title=item.getChildNodes().item(0).getNodeValue();
     myfeedresponse.pubdate=item.getChildNodes().item(3).getNodeValue();
     myfeedresponse.description=item.getChildNodes().item(4).getNodeValue();

 }
       catch(Exception e){
        e.printStackTrace();
    }
    return myfeedresponse;
}
}
