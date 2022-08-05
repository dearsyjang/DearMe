import BoardListView from '@/views/board/BoardListView.vue'
import ArticleView from '@/views/board/ArticleView.vue'
import ArticleUpdateView from '@/views/board/ArticleUpdateView.vue'
import ArticleCreateView from '@/views/board/ArticleCreateView.vue'

export default [
  {
    path: '/board',
    name: 'board',
    component: BoardListView
  },
  {
    path: '/board/create',
    name: 'articleCreate',
    component: ArticleCreateView
  },
  {
    path: '/board/1', // :articlePK
    name: 'articleView',
    component: ArticleView
  },
  {
    path: '/board/:articlePk/update',
    name: 'articleUpdate',
    component: ArticleUpdateView
  }
]