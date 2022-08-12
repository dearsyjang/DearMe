import BoardListView from '@/views/board/BoardListView.vue'
import BoardDetailVeiw from '@/views/board/BoardDetailView.vue'
import BoardUpdateView from '@/views/board/BoardUpdateView.vue'
import BoardCreateView from '@/views/board/BoardCreateView.vue'

export default [
  {
    path: '/board',
    name: 'board',
    component: BoardListView
  },
  {
    path: '/board/create',
    name: 'boardCreate',
    component: BoardCreateView
  },
  {
    path: '/board/:boardPk',
    name: 'boardDetail',
    component: BoardDetailVeiw
  },
  {
    path: '/board/:articlePk/update',
    name: 'boardUpdate',
    component: BoardUpdateView
  }
]