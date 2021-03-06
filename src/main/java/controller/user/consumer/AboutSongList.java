package controller.user.consumer;

import entity.MusicSongList;
import entity.SongList;
import entity.SongListCollect;
import entity.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.user.consumer.AboutSongListService;
import util.exception.DataBaseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 创建编辑歌单或专辑，收藏或取消收藏歌单或专辑，添加历史播放记录，在歌单或专辑中添加音乐
 *
 * @author 5月15日 张易兴创建
 */
@Controller
@RequestMapping(value = "/user")
public class AboutSongList {
    @Resource(name = "AboutSongListService")
    AboutSongListService aboutSongListService;
    private static final Logger logger = LoggerFactory.getLogger(AboutSongList.class);


    /**
     * 显示用户创建的所有歌单或专辑
     * @param  type 1是歌单2是专辑
     */
    @RequestMapping(value = "/showUserSongList")
    @ResponseBody
    public List<SongList> showUserSongList(Integer type, HttpSession session){
        return aboutSongListService.showUserSongList(type,session);
    }
    /**
     * 显示用户收藏的所有歌单或专辑
     * @param  type 1是歌单2是专辑
     */
    @RequestMapping(value = "/showUserCollectionSongList")
    @ResponseBody
    public List<SongListCollect> showUserCollectionSongList(Integer type, HttpSession session){
        return aboutSongListService.showUserCollectionSongList(type,session);
    }




    /**
     * 创建歌单或专辑
     *
     * @param songList 获取传来的歌单信息
     *                 name           获取歌单或专辑的标题
     *                 picture        获取歌单或专辑的封面的图片路径
     *                 introduction   获取歌单或专辑的介绍
     *                 classification 获取分类
     *                 type           获取类型1是歌单2是专辑
     * @param session  获取当前会话
     */
    @RequestMapping(value = "/createMusicSongList")
    @ResponseBody
    public State createMusicSongList(@RequestBody SongList songList, HttpServletRequest request, HttpSession session) throws IOException, DataBaseException {
        logger.trace("createMusicSongList方法开始执行");
        return aboutSongListService.createMusicSongList(songList, request, session);
    }

    /**
     * 编辑歌单或专辑
     *
     * @param songList 获取传来的歌单信息
     *                 name           获取歌单或专辑的标题
     *                 introduction   获取歌单或专辑的介绍
     *                 classification 获取分类
     *                 type           获取类型1是歌单2是专辑
     */
    @RequestMapping(value = "/editMusicSongList")
    @ResponseBody
    public State editMusicSongList(@RequestBody SongList songList) throws DataBaseException {
        logger.trace("editMusicSongList方法开始执行");
        return aboutSongListService.editMusicSongList(songList);
    }

    /**
     * 编辑歌单或专辑的封面图片
     *
     * @param id 需要更改的歌单或专辑的id
     */
    @RequestMapping(value = "/editMusicSongListPicture")
    @ResponseBody
    public State editMusicSongListPicture(Integer id, HttpServletRequest request) throws IOException, DataBaseException {
        logger.trace("editMusicSongListPicture方法开始执行");
        return aboutSongListService.editMusicSongListPicture(id, request);
    }

    /**
     * 删除歌单或专辑，ajax  还需删除图片
     *
     * @param id 需要删除歌单或专辑的id
     */
    @RequestMapping(value = "/deleteMusicSongList")
    @ResponseBody
    public State deleteMusicSongList(Integer id) throws DataBaseException {
        logger.trace("deleteMusicSongList方法开始执行");
        return aboutSongListService.deleteMusicSongList(id);
    }

    /**
     * 收藏或取消收藏歌单或专辑,ajax
     *
     * @param id               获取收藏歌单或专辑的id
     * @param type             获取类型1是歌单2是专辑
     * @param session          获取当前会话
     */
    @RequestMapping(value = "/collectionSongList")
    @ResponseBody
    public State collectionSongList(Integer id, Integer type, HttpSession session) throws DataBaseException {
        logger.trace("collectionSongList方法开始执行");
        return aboutSongListService.collectionSongList(id, type, session);
    }

    /**
     * 将指定音乐添加到专辑或歌单中
     *
     * @param musicSongList 获取需要添加到指定专辑或歌单中的音乐
     *                      所需参数：
     *                      belongId 专辑或歌单的id
     *                      type 1是歌单2是专辑
     *                      musicId 音乐的id
     */
    @RequestMapping(value = "/SongListAddMusic")
    @ResponseBody
    public State addMusicSongList(@RequestBody MusicSongList musicSongList,HttpSession session) throws DataBaseException {
        return aboutSongListService.addMusicSongList(musicSongList,session);
    }

}
