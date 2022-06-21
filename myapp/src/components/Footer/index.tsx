import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-layout';
import {OXIDANER_TOP} from "@/constants";

const Footer: React.FC = () => {
  const defaultMessage = '蚂蚁集团体验技术部出品';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: '个人主页',
          title: 'User BlOG',
          href: {OXIDANER_TOP},
          blankTarget: true,
        },
        {
          key: 'github',
          title: <><GithubOutlined />Oxidaner GitHub</>,
          href: 'https://github.com/oxidaner',
          blankTarget: true,
        },
        {
          key: 'codeNav',
          title: '编程导航',
          href: 'https://www,code-nav.cn',
          blankTarget: true,
        },
      ]}
    />
  );
};

export default Footer;
