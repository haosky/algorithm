package com.haosky.algorithm;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.haosky.algorithm.modules.PlayerSourceInfo;
import com.haosky.algorithm.modules.SourceInfoNode;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * Created by jianhao on 4/12/2018.
 *
 *  channel manager
 *
 *
 */

@RestController
@RequestMapping("/chl")
public class ChildChannelManagerController {

    @Autowired
    private MongoOperations operations;

    @RequestMapping("/sourceinfo/getTreeChl")
    @ResponseBody
    public Map<String, SourceInfoNode> getTreeChlBuild(
            @RequestParam(value = "company", required = false) String company
            ,@RequestParam(value = "mainSource", required = false) String mainSource
            ,@RequestParam(value = "ChildSource", required = false) String ChildSource
            ,@RequestParam(value = "GameId", required = false) String GameId) {
        int level = 0;
        Map<String, SourceInfoNode> sources = new HashMap<String, SourceInfoNode>();
        Map<String, SourceInfoNode> parentSources = new HashMap<String, SourceInfoNode>();
        boolean isRoot = true;
        while (true) {
            level++;
            BasicDBObject filterjson = BasicDBObject.parse("{\"level\":" + level + "}");
            FindIterable<Document> results = operations.getCollection("source_info").find(filterjson);
            boolean noData = true;
            for (Document doc : results) {
                noData = false;
                PlayerSourceInfo sinfo = new PlayerSourceInfo();
                sinfo.setLevel(doc.getInteger("level"));
                sinfo.setParentId(doc.get("parent_id") + "");
                sinfo.setId(doc.getString("_id"));
                sinfo.setSource(doc.getString("source"));
                sinfo.setSourceName(doc.getString("source_name"));
                sinfo.setState(doc.get("state") + "");
                sinfo.setPlatform(doc.getString("platform"));
                sinfo.setGameId(doc.get("game_id") + "");
                sinfo.setCreateAt(doc.getLong("create_at"));
                sinfo.setMessageTime(doc.getLong("message_time"));
                sinfo.setUpdateAt(doc.getLong("update_at"));
                SourceInfoNode sn = new SourceInfoNode();
                sn.setSource(sinfo);
                sn.setNodeid(sinfo.getId());
                sn.setIsRoot(isRoot);
                sources.put(sinfo.getId(), sn);
                parentSources.put(sinfo.getSource()+ "|" + sinfo.getGameid() + "|" + (sinfo.getLevel()), sn);
            }
            if (noData) break;
            isRoot = false;
        }
        Map<String, SourceInfoNode> tree = new HashMap<String, SourceInfoNode>();
        for(String nk : sources.keySet())
        {
            SourceInfoNode sn = sources.get(nk);
            if(sn.getParentSource()==null){
                sn.setParentSource(new ArrayList<SourceInfoNode>());
            }
            PlayerSourceInfo sinfo = sn.getSource();
            String parentId = sinfo.getParentid() + "|" + sinfo.getGameid() + "|" + (sinfo.getLevel()-1);
            try {
                sn.getParentSource().add(
                        parentSources.get(parentId)
                );
            }catch (Exception e){
                e.printStackTrace();
            }
            sources.put(nk,sn);
            tree.put(sn.getNodeid(),sn);
        }
    return tree;
    }
}
