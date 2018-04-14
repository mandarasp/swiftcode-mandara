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
     FeedResponse feedresponse= new FeedResponse();
     try{
         WSRequest queryRequest=ws.url("http://news.google.com/news");
         CompletionStage<WSReponse>responsePromise=queryRequest
                 .setQueryParameter(name:"q",value:"srh")
               .setQueryParameter("output","rss")
             .get();
     Document feedresponse =responsePromise.thenApply(WSResponse::asXml).toCompletableFuture().get();
     Node item=feedresponse.getFirstChild().getChildNodes().item(index:10);
     feedresponseobj.title=item.getChildNodes().item(index:0).getNodeValue();
     feedresponseobj.pubdate=item.getChildNodes().item(index:3).getNodeValue();
     feedresponseobj.description=item.getChildNodes().item(index:4).getNodeVlue();

 }
       catch(Exception e){
        e.printStackTrace();
    }
    return feedResponseObject;
}
